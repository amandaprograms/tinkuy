document.addEventListener("DOMContentLoaded", function () {
    const btnToggle = document.getElementById("btnToggleEstadisticas");
    const seccionEstadisticas = document.getElementById("seccionEstadisticas");
    const iconoEstadisticas = document.getElementById("iconoEstadisticas");

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

    if (storageDisponible() && localStorage.getItem("estadisticasOcultas") === "true") {
        seccionEstadisticas.classList.add("d-none");
        iconoEstadisticas.className = "bi bi-eye";
        document.documentElement.classList.remove("ocultar-estadisticas-init");
    } else {
        iconoEstadisticas.className = "bi bi-eye-slash";
    }

    btnToggle.addEventListener("click", function () {
        if (seccionEstadisticas.classList.contains("d-none")) {
            seccionEstadisticas.classList.remove("d-none");
            iconoEstadisticas.className = "bi bi-eye-slash";
            if (storageDisponible()) {
                localStorage.setItem("estadisticasOcultas", "false");
            }
        } else {
            seccionEstadisticas.classList.add("d-none");
            iconoEstadisticas.className = "bi bi-eye";
            if (storageDisponible()) {
                localStorage.setItem("estadisticasOcultas", "true");
            }
        }
    });
});