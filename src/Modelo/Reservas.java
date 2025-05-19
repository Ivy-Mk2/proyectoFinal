package modelo;

public class Reservas {
    private int id;
    private int idUsuario;
    private int idMesa;
    private String fecha;      // Formato sugerido: "2024-05-10"
    private String hora;       // Formato sugerido: "10:30 AM"
    private String estado;     // Ej: "Confirmada", "Cancelada", "Reagendada"
    private String comentario;
    private String ubicacion;

    public Reservas() {
    }
 
    public Reservas(int id, int idUsuario, int idMesa, String fecha, String hora, String estado,String ubicacion,String comentario) {
        this.id=id;
        this.idUsuario = idUsuario;
        this.idMesa = idMesa;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.ubicacion=ubicacion;
        this.comentario=comentario;
    }
    
    public Reservas(int idUsuario, int idMesa, String fecha, String hora, String estado,String ubicacion,String comentario) {
        this.idUsuario = idUsuario;
        this.idMesa = idMesa;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.ubicacion=ubicacion;
        this.comentario=comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idMesa=" + idMesa +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
