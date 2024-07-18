/**
 * 
 */


 const btn = document.getElementById("btn");
 const ch = document.getElementsByClassName("ch");
 const joinForm = document.getElementById("joinForm");
 const passworderror = document.getElementById("password-error");
 // const 변수명 = {}; 객체 생성
 
 const userName = document.getElementById("userName");
 const password = document.getElementById("password");
 const name = document.getElementById("name");
 const email = document.getElementById("email");
 const phone = document.getElementById("phone");
 const address = document.getElementById("address");




 
 btn.addEventListener("click", function (){

    if(userName.value==''){
        alert('ID를 입력하세요.');
        userName.focus();
        return;
    }

    if(password.value==''){
        passworderror.innerHTML="password는 필수입니다.";
        password.focus();
        return;
    } else if (password.value.length<8) {
        passworderror.innerHTML="password는 8자가 넘어야합니다.";
        password.focus();
        return;
    }


    //  let checks = true;
     // for(let i=0;i<ch.length;i++){
    //     if(ch[i].value!=""){
    //         checks[i]=true;
    //     }
    // }

    // let result = true;

    // for(let c of checks){
    //     if(!c){
    //         let result = false;
    //     }
    // }
    
    // if(result){
    //     alert('ok');
    // } else {
    //     alert('fail');
    // }

    // let pw;
    
    // for(let i=0;i<ch.length;i++){
    //     if(ch[i].value==''){
    //         checks=false;
    //         pw=i;
    //         break;
    //     } 
    // }

    // if(i=2){
    //     const i = document.createElement("input");
    //     i.value = "비밀번호 입력하세요.";
    //     i.setAttribute("disabled","");
    //     passworderror.append(i);
    // }

    // if(checks){
    //     joinForm.submit();
    // } else {
    //     alert('빈칸을 채우세요.');
    // }



 })