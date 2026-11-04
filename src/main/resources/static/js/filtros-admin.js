document.addEventListener("DOMContentLoaded", function () {
    const btnToggle = document.getElementById("btnToggleFiltros");
    const panelFiltros = document.getElementById("panelFiltros");
    const iconoFiltros = document.getElementById("iconoFiltros");

    function storageDisponible() {
        try {
            const x = "__tinkuy_test__";
            localStorage.setItem(x, x);
            localStorage.removeItem(x);
            return true;
        } catch (e) {
            return false;
        }
    }

    const ocultos = storageDisponible() &&
        localStorage.getItem("filtrosOcultos") !== "false";

    if (ocultos) {
        panelFiltros.classList.add("d-none");
        iconoFiltros.className = "bi bi-chevron-down";
    } else {
        panelFiltros.classList.remove("d-none");
        iconoFiltros.className = "bi bi-chevron-up";
    }

    panelFiltros.classList.remove("filtros-ocultos-init");

    btnToggle.addEventListener("click", function () {
        if (panelFiltros.classList.contains("d-none")) {
            panelFiltros.classList.remove("d-none");
            iconoFiltros.className = "bi bi-chevron-up";

            if (storageDisponible()) {
                localStorage.setItem("filtrosOcultos", "false");
            }
        } else {
            panelFiltros.classList.add("d-none");
            iconoFiltros.className = "bi bi-chevron-down";

            if (storageDisponible()) {
                localStorage.setItem("filtrosOcultos", "true");
            }
        }
    });

    const formulario = panelFiltros.closest("form");

    if (formulario) {
        formulario.addEventListener("submit", function () {
            if (storageDisponible()) {
                localStorage.setItem("filtrosOcultos", "false");
            }
        });
    }

    const botonBorrar = document.querySelector(
        'a[href*="/animales/sinfiltros"]'
    );

    if (botonBorrar) {
        botonBorrar.addEventListener("click", function () {
            if (storageDisponible()) {
                localStorage.setItem("filtrosOcultos", "false");
            }
        });
    }
});