document.addEventListener("DOMContentLoaded",a=>{
    const addButton = document.getElementById("addButton");
    let screenWidth = a.srcElement.documentElement.clientWidth;
    let screenHeight = a.srcElement.documentElement.clientHeight;
    let addButtonWidth = addButton.offsetWidth;
    let addButtonHeight = addButton.offsetHeight;
    addButton.style.left = `${screenWidth-addButtonWidth-20}px`;
    addButton.style.top = `${screenHeight-addButtonHeight-20}px`;

    window.addEventListener("resize",b=>{
        let screenWidth = b.srcElement.innerWidth;
        let screenHeight = b.srcElement.innerHeight;
        addButton.style.left = `${screenWidth-addButtonWidth-20}px`;
        addButton.style.top = `${screenHeight-addButtonHeight-20}px`;
    })

    console.log(a);
})