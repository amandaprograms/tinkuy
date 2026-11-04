(function () {
    try {
        if (localStorage.getItem("estadisticasOcultas") === "true") {
            document.documentElement.classList.add("ocultar-estadisticas-init");
        }
    } catch (e) {
        //No se realiza ninguna acción
    }
})();

(function () {
    try {
        if (localStorage.getItem("filtrosOcultos") !== "false") {
            document.documentElement.classList.add("ocultar-filtros-init");
        }
    } catch (e) {
        // No se realiza ninguna acción
    }
})();