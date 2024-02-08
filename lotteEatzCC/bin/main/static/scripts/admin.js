function setActiveMenuItem() {
    const currentPath = window.location.pathname; 
    const menuItems = document.querySelectorAll('.menu-item a');

    menuItems.forEach(item => {
        if (item.getAttribute('href') === currentPath) {
            item.parentElement.classList.add('active'); 
        }
    });
}

function changeActiveMenu(element) {
    document.querySelectorAll('.menu-item').forEach(item => {
        item.classList.remove('active'); 
    });
    element.classList.add('active'); 
}

window.onload = setActiveMenuItem; 
