
const result = document.getElementById("result");
const add = document.getElementById("add");

//부모의 id값
let idx=0;
//최대 첨부파일 개수
let max=1;

//만든 횟수
let count=0;

function setMax(m){
    max=m;
}

add.addEventListener("click", function(){

    if(count>=max){
        alert('첨부파일 최대 '+max+" 개 가능");
        return;
    }

    let parent = document.createElement("div");
    parent.id = 'file'+idx;
    parent.classList.add("input-group","mb-3");

    let addFile = document.createElement("input");
    addFile.setAttribute("type","file");
    addFile.name="files";
    addFile.classList.add("form-control");
    parent.append(addFile);

    let div = document.createElement("div");
    div.classList.add("input-group-append");
    let span = document.createElement("span");
    span.classList.add("input-group-text");
    span.setAttribute("id","del");

    //자식의 속성에 부모의 id를 입력
    span.setAttribute("data-del-id", 'file'+idx);
    span.innerText="X";
    div.append(span);

    parent.append(div);

    result.append(parent);

    idx++;
    count++;

 })

 result.addEventListener("click", function(e){
    if(e.target.id=='del'){
        // e.target.parentNode.parentNode.remove();

        // 자식 속성에 있는 부모의 id로 부모를 찾아 지운다.
        let ids = e.target.getAttribute("data-del-id");
        document.getElementById(ids).remove();

        count--;
        
    }
 })