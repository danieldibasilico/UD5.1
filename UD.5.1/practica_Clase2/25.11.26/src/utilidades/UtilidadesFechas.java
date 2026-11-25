package utilidades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Clase de utilidades con métodos estáticos para trabajar con fechas
 * (LocalDate).
 * No se puede instanciar.
 */
public final class UtilidadesFechas {

    private static final DateTimeFormatter FORMATO_ES = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Object ultimoDiaDelMes;

    private UtilidadesFechas() {
        // Evita la creación de instancias
    }

    // ---------- Diferencias entre fechas ----------

    /** Días totales entre dos fechas (negativo si fin es anterior a inicio). */
    public static long diasEntre(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.DAYS.between(inicio, fin);
    }

    /** Meses completos entre dos fechas. */
    public static long mesesEntre(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.MONTHS.between(inicio, fin);
    }

    /** Años completos entre dos fechas. */
    public static long aniosEntre(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.YEARS.between(inicio, fin);
    }

    /** Periodo (años, meses y días) entre dos fechas. */
    public static Period periodoEntre(LocalDate inicio, LocalDate fin) {
        return Period.between(inicio, fin);
    }

    // ---------- Edad y cumpleaños ----------

    /** Edad en años a día de hoy. */
    public static int calcularEdad(LocalDate fechaNacimiento) {
        return calcularEdad(fechaNacimiento, LocalDate.now());
    }

    /** Edad en años a una fecha de referencia. */
    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate referencia) {
        if (fechaNacimiento.isAfter(referencia)) {
           return  -1; 
        }
        return Period.between(fechaNacimiento, referencia).getYears();
    }

    /** Días que faltan hasta el próximo cumpleaños (0 si es hoy). */
    public static long diasParaCumpleanos(LocalDate fechaNacimiento) {
        LocalDate hoy = LocalDate.now();
        LocalDate proximo = fechaNacimiento.withYear(hoy.getYear());
        if (proximo.isBefore(hoy)) {
            proximo = proximo.plusYears(1);
        }
        return ChronoUnit.DAYS.between(hoy, proximo);
    }

    // ---------- Consultas sobre una fecha ----------

    public static boolean esBisiesto(int anio) {
        return LocalDate.of(anio, 1, 1).isLeapYear();
    }

    public static boolean esFinDeSemana(LocalDate fecha) {
        DayOfWeek dia = fecha.getDayOfWeek();
        return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
    }

    public static boolean esPasada(LocalDate fecha) {
        return fecha.isBefore(LocalDate.now());
    }

    public static boolean esFutura(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now());
    }

    /** true si la fecha está entre inicio y fin, ambos incluidos. */
    public static boolean estaEnRango(LocalDate fecha, LocalDate inicio, LocalDate fin) {
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }

    // ---------- Cálculos sobre el mes ----------

    public static LocalDate primerDiaDelMes(LocalDate fecha) {
        return fecha.withDayOfMonth(1);
    }

    public static LocalDate ultimoDiaDelMes(LocalDate fecha) {
        return fecha.withDayOfMonth(fecha.lengthOfMonth());
    }

    public static int diasDelMes(int anio, int mes) {
        return LocalDate.of(anio, mes, 1).lengthOfMonth();
    }

    // ---------- Sumas y restas ----------

    /**
     * Suma n días laborables (lunes a viernes) a una fecha.
     * No tiene en cuenta festivos.
     */
    public static LocalDate sumarDiasLaborables(LocalDate fecha, int dias) {
        LocalDate resultado = fecha;
        int paso = dias >= 0 ? 1 : -1;
        int restantes = Math.abs(dias);
        while (restantes > 0) {
            resultado = resultado.plusDays(paso);
            if (!esFinDeSemana(resultado)) {
                restantes--;
            }
        }
        return resultado;
    }

    /**
     * Cuenta los días laborables (lun-vie) entre dos fechas, inicio incluido y fin
     * excluido.
     */
    public static long contarDiasLaborables(LocalDate inicio, LocalDate fin) {
        return inicio.datesUntil(fin)
                .filter(d -> !esFinDeSemana(d))
                .count();
    }

    /**
     * Próxima fecha que cae en el día de la semana indicado (estrictamente
     * posterior a la dada).
     */
    public static LocalDate proximoDiaSemana(LocalDate fecha, DayOfWeek dia) {
        return fecha.with(java.time.temporal.TemporalAdjusters.next(dia));
    }

    // ---------- Formato y conversión ----------

    /** Formatea como dd/MM/yyyy. */
    public static String formatear(LocalDate fecha) {
        return fecha.format(FORMATO_ES);
    }

    /**
     * Convierte un texto dd/MM/yyyy en LocalDate. Devuelve null si el formato no es
     * válido.
     */
    public static LocalDate parsear(String texto) {
        try {
            return LocalDate.parse(texto, FORMATO_ES);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Crear una fecha usando año, mes dia
     * 
     * 
     *  */
    public static LocalDate crearFecha(int anio, int mes, int dia){

        return LocalDate.of(anio,mes,dia);

    }  
      /**
     * Crear una fecha en formato ISO (yyyy.MM.dd)
     * 
     * 
     *  */
    public static LocalDate crearFechaISO(String fecha){
        return LocalDate.parse(fecha);
    }

    /** Crear una fecha en formato (dd/MM/yyyy) */

    public static LocalDate crearFechaOtroFormato(String fecha){
       DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formato);
    }

    /**
     * Sumar días a una fecha
     * 

     */
    public static LocalDate sumarDias (LocalDate fecha, int dias){
        return fecha.plusDays(dias); 
    }

}