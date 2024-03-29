async function load() {
    let result = document.querySelector('.results');
    await generateListOfUsers(result);
    genPrev();
    await genNext();

    if (await isAuth()) {
        console.log("asdasdsa");
        genLogout();
        if (await isAdmin()) {
            console.log("admin")
            await genRoom();
            await genAdminCreate();
            await genAdminUpdate();
            await genAdminDelete();
            await genListOfRoomsForAdmin();
            await genAdminInfo();


        } else {
            await genListOfCompStuffForUser();
            await userSearch();
            await genUserInfo();
        }
    } else {
        genLogReg(result);
    }
}

async function genUserSearchButton() {
    let token = localStorage.getItem('token');
    let inputResult = document.getElementById('searchPatientCard').value;
    if(inputResult.length===0){
        await genListOfCompStuffForUser();
    }else{
        let someList = document.querySelector('.someList');
        someList.innerHTML = '';
        let listProject = await getAllRoomsForUser(token);

        for (let i = 0; i < listProject.length; i++) {
            let genDiv = div();
            if (inputResult === listProject[i]['name'] || inputResult === listProject[i]['description']) {
                let genP1 = p(listProject[i]['name'] + ' ' + listProject[i]['description'] + ' ' + listProject[i]['cost']);
                let genBut = buttonWithParams('get');

                genBut.onclick = async () => {
                    await getCertainCompUser(listProject[i]);
                };
                genDiv.appendChild(genP1);
                genDiv.appendChild(genBut);
                someList.appendChild(genDiv);
            }
        }
    }
}

async function userSearch() {

    let search = document.querySelector('.search');
    let searchButton = button(await genUserSearchButton, 'Search');
    let searchPatientCard = input('text','searchPatientCard','Enter the name of the room or description...');
    searchButton.id = 'docCreateButton';
    search.appendChild(searchPatientCard);
    search.appendChild(searchButton);
}