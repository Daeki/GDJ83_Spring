const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById('commentClose');
const commentList = document.getElementById("commentList");


getList(1);

function getList(page){
    fetch("commentList?bookNumber="+commentButton.getAttribute("data-id")+"&page="+page, {
        method:"GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}

commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("ups")){
        let id=e.target.getAttribute("data-del-id");
        let c = e.target.getAttribute("data-update-con");
        c = document.getElementById(c).innerHTML;
        commentContents.value=c;
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


commentButton.addEventListener("click", ()=>{
    commentClose.click();
    let contents =commentContents.value;

    fetch("commentAdd", {
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"boardContents="+contents+"&bookNumber="+commentButton.getAttribute("data-id")
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert('댓글추가')
            getList(1);
        }
    })

    commentContents.value="";
})