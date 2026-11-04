document.addEventListener("DOMContentLoaded", function () {
    const miTabla = initCustomDataTable("#tablaAnimalesAdmin", {
        searchable: true,
        perPage: 5,
        firstLast: true,
        firstText: "Primero",
        lastText: "Último",
        prevText: "‹",
        nextText: "›",
        columns: [{ select: [10], sortable: false }],
        labels: {
            perPage: "registros por página",
            noRows: "No se encontraron resultados",
            info: "Mostrando {start} a {end} de {rows} registros",
        }
    });

    if (!miTabla) return;

    const inputExterno = document.querySelector("#buscadorExterno");
    if (inputExterno) {
        inputExterno.addEventListener("input", function (e) {
            miTabla.search(e.target.value);

            setTimeout(() => {
                const wrapper = document.querySelector("#tablaAnimalesAdmin").closest(".datatable-wrapper");
                if (wrapper) {
                    const infoDiv = wrapper.querySelector(".datatable-empty");
                    if (infoDiv) {
                        infoDiv.textContent = "No se encontraron resultados";
                    }
                }
            }, 50);
        });
    }
});

const modalEliminar = document.querySelector("#modalEliminar");

if (modalEliminar) {
    modalEliminar.addEventListener("show.bs.modal", function (event) {
        const boton = event.relatedTarget;

        if (boton) {
            modalEliminar.querySelector("#modalEliminarNombre").textContent = boton.dataset.nombre;
            modalEliminar.querySelector("#formEliminar").action = boton.dataset.url;
        }
    });
}