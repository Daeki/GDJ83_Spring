const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById('commentClose');
const commentList = document.getElementById("commentList");


getList();

function getList(){
    fetch("commentList?bookNumber="+commentButton.getAttribute("data-id"), {
        method:"GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}


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
            getList();
        }
    })

    commentContents.value="";
})