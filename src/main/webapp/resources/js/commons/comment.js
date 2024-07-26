const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById('commentClose');
const commentList = document.getElementById("commentList");
const openModal = document.getElementById("openModal");


getList(1);

function getList(page){
    fetch("commentList?bookNumber="+commentButton.getAttribute("data-id")+"&page="+page, {
        method:"GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}

//true:등록, false:수정
let flag=true;
let boardNum=0;
//openModal
openModal.addEventListener("click", ()=>{
    flag=true;
    commentButton.innerHTML="댓글등록";
    commentContents.value="";
})

//수정
commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("ups")){
        flag=false;
        //댓글번호
        boardNum=e.target.getAttribute("data-del-id");
        let c = e.target.getAttribute("data-update-con");
        c = document.getElementById(c).innerHTML;
        commentContents.value=c;
        commentButton.innerHTML="댓글수정";
    }
})

commentList.addEventListener("click", (e)=>{
    e.preventDefault();
    if(e.target.classList.contains("pn")){
       let p= e.target.getAttribute("data-page-num");
       getList(p);
    }
})

commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("dels")){
        let id =e.target.getAttribute("data-del-id");
        fetch("commentDelete", {
            method:"POST",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body:"boardNum="+id
        })
        .then(r=>r.text())
        .then(r=>{
            r=r.trim();
            if(r>0){
                alert('삭제 성공')
                getList(1)
            }else {
                alert('삭제 실패')
            }
        })
    }
})



//등록, 수정 
commentButton.addEventListener("click", ()=>{
    let contents =commentContents.value;
    let msg="댓글 추가 성공";
    if(contents==null || contents==""){
        alert("댓글을 입력");
        return;
    }

    let url="commentAdd";
    let param="boardContents="+contents+"&bookNumber="+commentButton.getAttribute("data-id");

    if(!flag){
        url="commentUpdate";
        param="boardContents="+contents+"&boardNum="+boardNum;
        msg = "댓글 수정 성공"
    }

    console.log(url);
    console.log(param);
    commentClose.click();

    fetch(url, {
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:param
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert(msg);
            getList(1);
        }
    })

    commentContents.value="";
})