document.addEventListener("DOMContentLoaded", function () {
    const fotoPrincipal = document.getElementById("fotoPrincipal");
    const miniaturas = document.querySelectorAll(".miniatura-btn");

    if (fotoPrincipal && miniaturas.length > 0) {
        miniaturas.forEach(function (boton) {
            boton.addEventListener("click", function () {
                fotoPrincipal.src = boton.dataset.src;
                fotoPrincipal.alt = boton.dataset.alt;

                miniaturas.forEach(function (otra) {
                    const esLaPulsada = otra === boton;
                    otra.classList.toggle("activa", esLaPulsada);
                    otra.setAttribute("aria-pressed", String(esLaPulsada));
                });
            });
        });
    }
});
