function validateLoginPass(login, password, email) {
    if (!(login.length >= 4 && login.length <= 16)) {
        return "Not correct login";
    }
    if (!(password.length >= 4 && password.length <= 16)) {
        return "Not correct password";
    }
    if (!email.length >= 4 || !email.includes("@")) {
        return "Not correct email";
    }
    return true;
}

async function regUser(data) {
    return await fetch("/register", {
        method: "POST",
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)
    });
}

async function reg() {
    let login = document.getElementById("login").value;
    let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;
    let mes = document.getElementById("message");
    let result = validateLoginPass(login, password , email);
    if (result === true) {
        let data = {login: login, password: password,email:email};
        let res = await regUser(data);
        if (res.ok) {
            mes.innerHTML = "Check your email address to continue your registration"
            //window.location.replace(window.location.origin);
        } else {
            mes.innerHTML = "this user already exist";
        }
    } else {
        mes.innerHTML = result;
    }
}