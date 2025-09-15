// Ejercicios de Relaciones 1 a 1

// Ejercicio 1: Pasaporte - Foto - Titular
// a. Composición: Pasaporte → Foto
// b. Asociación bidireccional: Pasaporte ↔ Titular
class Foto {
    private String imagen;
    private String formato;

    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }
}

class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte; // bidireccional

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }
}

class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Foto foto; // composición
    private Titular titular; // bidireccional

    public Pasaporte(String numero, String fechaEmision, Foto foto, Titular titular) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = foto;
        this.titular = titular;
        titular.setPasaporte(this); // establece relación bidireccional
    }
}

// Ejercicio 2: Celular - Batería - Usuario
// a. Agregación: Celular → Batería
// b. Asociación bidireccional: Celular ↔ Usuario
class Bateria {
    private String modelo;
    private int capacidad;

    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
}

class Usuario {
    private String nombre;
    private String dni;
    private Celular celular;

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }
}

class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria; // agregación
    private Usuario usuario; // bidireccional

    public Celular(String imei, String marca, String modelo, Bateria bateria, Usuario usuario) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
        this.usuario = usuario;
        usuario.setCelular(this);
    }
}

// Ejercicio 3: Libro - Autor - Editorial
// a. Asociación unidireccional: Libro → Autor
// b. Agregación: Libro → Editorial
class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
}

class Editorial {
    private String nombre;
    private String direccion;

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}

class Libro {
    private String titulo;
    private String isbn;
    private Autor autor; // asociación unidireccional
    private Editorial editorial; // agregación

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }
}

// Ejercicio 4: TarjetaDeCrédito - Cliente - Banco
// a. Asociación bidireccional: TarjetaDeCrédito ↔ Cliente
// b. Agregación: TarjetaDeCrédito → Banco
class Banco {
    private String nombre;
    private String cuit;

    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }
}

class Cliente {
    private String nombre;
    private String dni;
    private TarjetaDeCredito tarjeta;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta) { this.tarjeta = tarjeta; }
}

class TarjetaDeCredito {
    private String numero;
    private String fechaVencimiento;
    private Cliente cliente; // bidireccional
    private Banco banco;     // agregación

    public TarjetaDeCredito(String numero, String fechaVencimiento, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cliente = cliente;
        this.banco = banco;
        cliente.setTarjeta(this);
    }
}

// Ejercicio 5: Computadora - PlacaMadre - Propietario
// a. Composición: Computadora → PlacaMadre
// b. Asociación bidireccional: Computadora ↔ Propietario
class PlacaMadre {
    private String modelo;
    private String chipset;

    public PlacaMadre(String modelo, String chipset) {
        this.modelo = modelo;
        this.chipset = chipset;
    }
}

class Propietario {
    private String nombre;
    private String dni;
    private Computadora computadora;

    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setComputadora(Computadora computadora) { this.computadora = computadora; }
}

class Computadora {
    private String marca;
    private String numeroSerie;
    private PlacaMadre placaMadre; // composición
    private Propietario propietario; // bidireccional

    public Computadora(String marca, String numeroSerie, PlacaMadre placaMadre, Propietario propietario) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.placaMadre = placaMadre;
        this.propietario = propietario;
        propietario.setComputadora(this);
    }
}

// Ejercicio 6: Reserva - Cliente - Mesa
// a. Asociación unidireccional: Reserva → Cliente
// b. Agregación: Reserva → Mesa
class ClienteReserva {
    private String nombre;
    private String telefono;

    public ClienteReserva(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}

class Mesa {
    private int numero;
    private int capacidad;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
}

class Reserva {
    private String fecha;
    private String hora;
    private ClienteReserva cliente; // asociación unidireccional
    private Mesa mesa; // agregación

    public Reserva(String fecha, String hora, ClienteReserva cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }
}

// Ejercicio 7: Vehículo - Motor - Conductor
// a. Agregación: Vehículo → Motor
// b. Asociación bidireccional: Vehículo ↔ Conductor
class Motor {
    private String tipo;
    private String numeroSerie;

    public Motor(String tipo, String numeroSerie) {
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }
}

class Conductor {
    private String nombre;
    private String licencia;
    private Vehiculo vehiculo;

    public Conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }

    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
}

class Vehiculo {
    private String patente;
    private String modelo;
    private Motor motor; // agregación
    private Conductor conductor; // bidireccional

    public Vehiculo(String patente, String modelo, Motor motor, Conductor conductor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor;
        this.conductor = conductor;
        conductor.setVehiculo(this);
    }
}

// Ejercicio 8: Documento - FirmaDigital - Usuario
// a. Composición: Documento → FirmaDigital
// b. Agregación: FirmaDigital → Usuario
class UsuarioFirma {
    private String nombre;
    private String email;

    public UsuarioFirma(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}

class FirmaDigital {
    private String codigoHash;
    private String fecha;
    private UsuarioFirma usuario; // agregación

    public FirmaDigital(String codigoHash, String fecha, UsuarioFirma usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario;
    }
}

class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firmaDigital; // composición

    public Documento(String titulo, String contenido, FirmaDigital firmaDigital) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firmaDigital = firmaDigital;
    }
}

// Ejercicio 9: CitaMédica - Paciente - Profesional
// a. Asociación unidireccional: CitaMédica → Paciente,
// b. Asociación unidireccional: CitaMédica → Profesional
class Paciente {
    private String nombre;
    private String obraSocial;

    public Paciente(String nombre, String obraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }
}

class Profesional {
    private String nombre;
    private String especialidad;

    public Profesional(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
}

class CitaMedica {
    private String fecha;
    private String hora;
    private Paciente paciente; // asociación unidireccional
    private Profesional profesional; // asociación unidireccional

    public CitaMedica(String fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }
}

// Ejercicio 10: CuentaBancaria - ClaveSeguridad - Titular
// a. Composición: CuentaBancaria → ClaveSeguridad
// b. Asociación bidireccional: CuentaBancaria ↔ Titular
class ClaveSeguridad {
    private String codigo;
    private String ultimaModificacion;

    public ClaveSeguridad(String codigo, String ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }
}

class TitularCB {
    private String nombre;
    private String dni;
    private CuentaBancaria cuenta;

    public TitularCB(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCuenta(CuentaBancaria cuenta) { this.cuenta = cuenta; }
}

class CuentaBancaria {
    private String cbu;
    private double saldo;
    private ClaveSeguridad claveSeguridad; // composición
    private TitularCB titular; // bidireccional

    public CuentaBancaria(String cbu, double saldo, ClaveSeguridad claveSeguridad, TitularCB titular) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.claveSeguridad = claveSeguridad;
        this.titular = titular;
        titular.setCuenta(this);
    }
}

// Ejercicios de Dependencia de Uso

// Ejercicio 11: Reproductor - Canción - Artista
// a. Asociación unidireccional: Canción → Artista
// b. Dependencia de uso: Reproductor.reproducir(Cancion)
class Artista {
    private String nombre;
    private String genero;

    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }
}

class Cancion {
    private String titulo;
    private Artista artista; // asociación unidireccional

    public Cancion(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }
}

class Reproductor {
    public void reproducir(Cancion cancion) {
        System.out.println("Reproduciendo: " + cancion.titulo);
    }
}

// Ejercicio 12: Impuesto - Contribuyente - Calculadora
// a. Asociación unidireccional: Impuesto → Contribuyente
// b. Dependencia de uso: Calculadora.calcular(Impuesto)
class Contribuyente {
    private String nombre;
    private String cuil;

    public Contribuyente(String nombre, String cuil) {
        this.nombre = nombre;
        this.cuil = cuil;
    }
}

class Impuesto {
    private double monto;
    private Contribuyente contribuyente; // asociación unidireccional

    public Impuesto(double monto, Contribuyente contribuyente) {
        this.monto = monto;
        this.contribuyente = contribuyente;
    }
}

class Calculadora {
    public void calcular(Impuesto impuesto) {
        System.out.println("Calculando impuesto de: " + impuesto.monto);
    }
}

// Ejercicios de Dependencia de Creación

// Ejercicio 13: GeneradorQR - Usuario - CódigoQR
// a. Asociación unidireccional: CódigoQR → Usuario
// b. Dependencia de creación: GeneradorQR.generar(String, Usuario)
class UsuarioQR {
    private String nombre;
    private String email;

    public UsuarioQR(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}

class CodigoQR {
    private String valor;
    private UsuarioQR usuario; // asociación unidireccional

    public CodigoQR(String valor, UsuarioQR usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }
}

class GeneradorQR {
    public void generar(String valor, UsuarioQR usuario) {
        CodigoQR qr = new CodigoQR(valor, usuario);
        System.out.println("CódigoQR generado para usuario: " + usuario.nombre);
    }
}

// Ejercicio 14: EditorVideo - Proyecto - Render
// a. Asociación unidireccional: Render → Proyecto
// b. Dependencia de creación: EditorVideo.exportar(String, Proyecto)
class Proyecto {
    private String nombre;
    private int duracionMin;

    public Proyecto(String nombre, int duracionMin) {
        this.nombre = nombre;
        this.duracionMin = duracionMin;
    }
}

class Render {
    private String formato;
    private Proyecto proyecto; // asociación unidireccional

    public Render(String formato, Proyecto proyecto) {
        this.formato = formato;
        this.proyecto = proyecto;
    }
}

class EditorVideo {
    public void exportar(String formato, Proyecto proyecto) {
        Render render = new Render(formato, proyecto);
        System.out.println("Render exportado en formato: " + formato);
    }
}
