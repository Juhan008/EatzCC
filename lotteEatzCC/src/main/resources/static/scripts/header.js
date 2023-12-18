document.addEventListener('DOMContentLoaded', function () {
    var headerButtons = document.querySelectorAll('.header-deq2-btn');
    var subGnbLayer = document.querySelector('.sub-gnb-layer');
    var headerDep3Menus = document.querySelectorAll('.header-dep3-menu');
    var headerContainer = document.querySelector('.header-wrapper'); 

    headerButtons.forEach(function (button) {
        button.addEventListener('mouseenter', function () {
            subGnbLayer.style.height = '300px';
            subGnbLayer.style.boxShadow = '0 4px 10px rgba(0, 0, 0, 0.05)';
            
            // 모든 header-dep3-menu 요소를 보이게 설정
            headerDep3Menus.forEach(function (menu) {
                menu.style.display = 'block';
            });
        });
    });

    headerContainer.addEventListener('mouseleave', function () {
        subGnbLayer.style.height = '';
        subGnbLayer.style.boxShadow = '';
        headerDep3Menus.forEach(function (menu) {
            menu.style.display = 'none';
        });
    });
});
