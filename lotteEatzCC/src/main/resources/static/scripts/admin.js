function changeActiveMenu(element) {
    document.querySelectorAll('.menu-item').forEach(item => {
        item.classList.remove('active');
    });
    element.classList.add('active');
}
