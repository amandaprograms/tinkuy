window.initCustomDataTable = function(selectorId, CustomOptions = {}) {
    const targetElement = document.querySelector(selectorId);
    if (!targetElement) return null;

    let ConstructorInstance = null;
    if (typeof simpleDatatables !== 'undefined' && simpleDatatables.DataTable) {
        ConstructorInstance = simpleDatatables.DataTable;
    } else if (typeof simpleDatatables !== 'undefined') {
        ConstructorInstance = simpleDatatables;
    } else if (typeof window.simpleDatatables !== 'undefined') {
        ConstructorInstance = window.simpleDatatables;
    }

    if (!ConstructorInstance) {
        console.error("Simple-DataTables no está cargado en el sistema.");
        return null;
    }

    targetElement.classList.add('desvanecer-datatable');

    const defaultOptions = {
        searchable: true,
        fixedHeight: false,
        fixedColumns: false,
        scrollY: "",
        perPage: 10,
        paging: true,
        firstLast: true,
        nextPrev: true,
        classes: {
            wrapper: "datatable-wrapper property-table",
            container: "datatable-container table-responsive mt-2 mb-0",
            top: "datatable-top d-flex justify-content-start mb-3",
            bottom: "datatable-bottom row align-items-center mt-0 gy-3",
            search: "datatable-search position-relative",
            input: "form-control py-2 ps-5",
            dropdown: "datatable-dropdown",
            selector: "form-select form-select-sm w-auto mx-1",
            pagination: "datatable-pagination pagination pagination-sm mb-0",
            info: "datatable-info text-muted small"
        },
        labels: {
            placeholder: "Buscar...",
            searchTitle: "Buscar...",
            perPage: "registros por página",
            noRows: "No se encontraron resultados",
            info: "Mostrando {start} a {end} de {rows} registros",
            first: "Primero",
            last: "Último",
            next: ">",
            previous: "<"
        },
        template: (options, dom) => `
            <div class='${options.classes.top}' style="display: none !important;">
                <div class='${options.classes.search}'>
                    <input class='${options.classes.input}' type='search'>
                </div>
            </div>

            <div class='${options.classes.container}'></div>

            <div class='${options.classes.bottom}'>
                <div class='col-12 col-md-6 col-xl-4 order-2 order-md-1 d-flex justify-content-center justify-content-md-start'>
                    <div class='${options.classes.dropdown}'>
                        <label class="d-flex align-items-center mb-0 custom-dt-text">
                            <select class='${options.classes.selector}'></select> ${options.labels.perPage}
                        </label>
                    </div>
                </div>
                <div class='col-12 col-md-6 col-xl-4 order-3 order-md-2 order-xl-3 text-center text-md-end'>
                    <div class='${options.classes.info} custom-dt-text'></div>
                </div>
                <div class='col-12 col-xl-4 order-1 order-md-3 order-xl-2 d-flex justify-content-center'>
                    <nav class='${options.classes.pagination}'></nav>
                </div>
            </div>
        `
    };

    const finalOptions = Object.assign({}, defaultOptions, CustomOptions);

    if (CustomOptions.classes) {
        finalOptions.classes = Object.assign({}, defaultOptions.classes, CustomOptions.classes);
    }

    const datatableInstance = new ConstructorInstance(targetElement, finalOptions);

    datatableInstance.on("datatable.init", function() {
        targetElement.classList.add("datatable-init");
        const contenedorPadre = targetElement.closest('.cargando-tabla');
        if (contenedorPadre) {
            contenedorPadre.classList.remove('cargando-tabla');
        }
    });

    return datatableInstance;
}