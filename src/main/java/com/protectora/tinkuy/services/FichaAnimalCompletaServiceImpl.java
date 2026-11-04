package com.protectora.tinkuy.services;

import com.protectora.tinkuy.entities.Animal;
import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import com.protectora.tinkuy.entities.Solicitud;
import com.protectora.tinkuy.enumerations.CategoriaEdadEnum;
import com.protectora.tinkuy.enumerations.SexoAnimalEnum;
import com.protectora.tinkuy.enumerations.SituacionAnimalEnum;
import com.protectora.tinkuy.enumerations.TamanoAnimalEnum;
import com.protectora.tinkuy.models.AnimalesFiltrosAdmin;
import com.protectora.tinkuy.repositories.FichaAnimalCompletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FichaAnimalCompletaServiceImpl implements FichaAnimalCompletaService {

    private final FichaAnimalCompletaRepository fichaAnimalCompletaRepository;
    private final EstanciaAnimalService estanciaAnimalService;
    private final SolicitudAnimalService solicitudAnimalService;

    @Override
    public List<FichaAnimalCompleta> obtenerTodos() {

        return fichaAnimalCompletaRepository.findAll();
    }

    @Override
    public FichaAnimalCompleta obtenerPorId(Long id) throws RuntimeException {

        return fichaAnimalCompletaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado la ficha del animal"));
    }

    @Override
    @Transactional
    public FichaAnimalCompleta agregar(FichaAnimalCompleta fichaAnimalCompleta) {

        return fichaAnimalCompletaRepository.save(fichaAnimalCompleta);
    }

    @Override
    @Transactional
    public FichaAnimalCompleta editar(FichaAnimalCompleta fichaAnimalCompleta) throws RuntimeException {

        obtenerPorId(fichaAnimalCompleta.getAnimal().getId());
        return fichaAnimalCompletaRepository.save(fichaAnimalCompleta);
    }

    @Override
    @Transactional
    public void borrar(Long id) throws RuntimeException {

        obtenerPorId(id);
        fichaAnimalCompletaRepository.deleteById(id);
    }

    @Override
    public List<FichaAnimalCompleta> obtenerAnimalesConFicha() {

        List<FichaAnimalCompleta> fichas = new ArrayList<>();
        List<FichaAnimalCompleta> fichasEncontradas = fichaAnimalCompletaRepository.findAnimalesConFicha();

        if (fichasEncontradas != null) {
            fichas.addAll(fichasEncontradas);
        }
        return fichas;
    }

    @Override
    public List<FichaAnimalCompleta> obtenerResultFiltros(AnimalesFiltrosAdmin filtros) {

        SexoAnimalEnum sexo = filtros.sexo();
        TamanoAnimalEnum tamano = filtros.tamano();
        CategoriaEdadEnum edad = filtros.edad();
        Boolean ppp = filtros.ppp();
        Boolean urgente = filtros.urgente();
        String estado = filtros.estado();
        String esterilizado = filtros.esterilizado();
        String situacion = filtros.situacion();
        Long especieId = filtros.especieId();
        List<FichaAnimalCompleta> animalesConFicha = obtenerAnimalesConFicha();
        List<FichaAnimalCompleta> animalesFiltrados = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        for (FichaAnimalCompleta ficha : animalesConFicha) {
            boolean fichaValida = (ficha != null && ficha.getAnimal() != null);
            if (fichaValida) {
                Animal animal = ficha.getAnimal();
                boolean validado = true;
                if (validado && especieId != null) {
                    if (animal.getRaza() == null || animal.getRaza().getEspecie() == null || !especieId.equals(animal.getRaza().getEspecie().getId())) {
                        validado = false;
                    }
                }
                if (validado && sexo != null) {
                    if (animal.getSexo() != sexo) {
                        validado = false;
                    }
                }
                if (validado && tamano != null) {
                    if (animal.getTamano() != tamano) {
                        validado = false;
                    }
                }
                if (validado && edad != null) {
                    LocalDate fechaNacimiento = animal.getFechaNacimiento();
                    LocalDate fechaReferencia = hoy;
                    if (ficha.getFechaFallec() != null) {
                        fechaReferencia = ficha.getFechaFallec();
                    }
                    if (fechaNacimiento == null || fechaNacimiento.isAfter(fechaReferencia)) {
                        validado = false;
                    } else {
                        long anios = ChronoUnit.YEARS.between(fechaNacimiento, fechaReferencia);
                        if (edad == CategoriaEdadEnum.CACHORRO && anios >= 1) {
                            validado = false;
                        } else if (edad == CategoriaEdadEnum.ADULTO && (anios < 1 || anios > 7)) {
                            validado = false;
                        } else if (edad == CategoriaEdadEnum.SENIOR && anios < 8) {
                            validado = false;
                        }
                    }
                }
                if (validado && ppp != null && ppp) {
                    if (animal.getPpp() == null || !animal.getPpp()) {
                        validado = false;
                    }
                }
                if (validado && urgente != null && urgente && !ficha.isUrgente()) {
                    validado = false;
                }
                if (validado && esterilizado != null && !esterilizado.isBlank()) {
                    Boolean esEsterilizado = animal.getEsterilizado();
                    if (esterilizado.equalsIgnoreCase("true") && (esEsterilizado == null || !esEsterilizado)) {
                        validado = false;
                    } else if (esterilizado.equalsIgnoreCase("false") && (esEsterilizado == null || esEsterilizado)) {
                        validado = false;
                    } else if (esterilizado.equalsIgnoreCase("desconocido") && esEsterilizado != null) {
                        validado = false;
                    }
                }
                if (validado && estado != null && !estado.isBlank()) {
                    boolean esFallecido = ficha.getFechaFallec() != null;
                    if (estado.equalsIgnoreCase("Activo") && esFallecido) {
                        validado = false;
                    } else if (estado.equalsIgnoreCase("Fallecido") && !esFallecido) {
                        validado = false;
                    }
                }
                if (validado && situacion != null && !situacion.isBlank()) {
                    String situacionCalculada = obtenerSituacionAnimal(ficha);
                    if (situacionCalculada == null || !situacionCalculada.equalsIgnoreCase(situacion.trim())) {
                        validado = false;
                    }
                }
                if (validado) {
                    animalesFiltrados.add(ficha);
                }
            }
        }
        return animalesFiltrados;
    }

    @Override
    public String obtenerSituacionAnimal(FichaAnimalCompleta ficha) {

        String situacion = SituacionAnimalEnum.NO_DISPONIBLE.getEtiqueta();

        if (ficha != null && ficha.getAnimal() != null) {
            Long animalId = ficha.getAnimal().getId();

            if (ficha.getFechaFallec() != null) {
                situacion = SituacionAnimalEnum.FALLECIDO.getEtiqueta();
            } else {
                boolean estaAdoptado = estanciaAnimalService.estaAdoptado(animalId);

                if (estaAdoptado) {
                    situacion = SituacionAnimalEnum.ADOPTADO.getEtiqueta();
                } else {
                    boolean estaEnAcogida = estanciaAnimalService.estaEnAcogida(animalId);

                    if (estaEnAcogida) {
                        situacion = SituacionAnimalEnum.EN_ACOGIDA.getEtiqueta();
                    } else if (ficha.isDisponibleAdopcion() || ficha.isDisponibleAcogida()) {
                        Solicitud ultimaSolicitud = solicitudAnimalService.obtenerUltimaSolicitud(ficha);
                        boolean procesadoPorSolicitud = false;

                        if (ultimaSolicitud != null && ultimaSolicitud.getEstado() != null) {
                            String estadoStr = ultimaSolicitud.getEstado().name();
                            String tipoStr = "";

                            if (ultimaSolicitud.getTipo() != null) {
                                tipoStr = ultimaSolicitud.getTipo().name();
                            }

                            boolean esAcogida = "ACOGIDA".equalsIgnoreCase(tipoStr);

                            if ("PENDIENTE".equals(estadoStr) || "ESPERANDO_CUESTIONARIO".equals(estadoStr)) {
                                situacion = SituacionAnimalEnum.SOLICITADO.getEtiqueta();
                                procesadoPorSolicitud = true;
                            } else if ("EN_TRAMITE".equals(estadoStr) || "ESPERANDO_REVISION".equals(estadoStr)) {

                                if (esAcogida) {
                                    situacion = SituacionAnimalEnum.EN_VALORACION_ACOGIDA.getEtiqueta();
                                } else if ("EN_TRAMITE".equals(estadoStr)) {
                                    situacion = SituacionAnimalEnum.EN_TRAMITE_ADOPCION.getEtiqueta();
                                } else {
                                    situacion = SituacionAnimalEnum.EN_REVISION_ADOPCION.getEtiqueta();
                                }
                                procesadoPorSolicitud = true;
                            } else if ("APROBADA".equals(estadoStr)) {

                                if (esAcogida) {
                                    situacion = SituacionAnimalEnum.EN_ACOGIDA.getEtiqueta();
                                } else {
                                    situacion = SituacionAnimalEnum.NO_DISPONIBLE.getEtiqueta();
                                }
                                procesadoPorSolicitud = true;
                            }
                        }

                        if (!procesadoPorSolicitud) {
                            situacion = SituacionAnimalEnum.DISPONIBLE.getEtiqueta();
                        }
                    }
                }
            }
        }
        return situacion;
    }

    @Override
    public Long obtenerTotalAnimales() {

        return fichaAnimalCompletaRepository.count();
    }

    @Override
    public Long obtenerTotalUrgentes() {

        return fichaAnimalCompletaRepository.countByUrgenteTrue();
    }

    @Override
    public Long obtenerTotalEnAdopcion() {

        long total = 0L;
        List<FichaAnimalCompleta> fichas = obtenerAnimalesConFicha();
        for (FichaAnimalCompleta ficha : fichas) {
            if (SituacionAnimalEnum.DISPONIBLE.getEtiqueta().equals(obtenerSituacionAnimal(ficha))) {
                total++;
            }
        }
        return total;
    }

    @Override
    public Long obtenerTotalAdoptados() {

        return fichaAnimalCompletaRepository.contarAnimalesAdoptados();
    }

    @Override
    public boolean estaAdoptado(Long animalId) {

        boolean adoptado = false;
        if (animalId != null) {
            adoptado = estanciaAnimalService.estaAdoptado(animalId);
        }
        return adoptado;
    }
}