

/**
 * Modela un pedido realizado por un cliente en una determinada fecha
 * El pedido incluye dos líneas de pedido que describen a cada uno de los dos
 * productos comprados en el pedido
 */
public class Pedido
{
    private final double IVA = 0.21;  // iva a aplicar
    private Fecha fecha;
    private Cliente cliente;
    private LineaPedido linea1;
    private LineaPedido linea2;

    /**
     * Constructor  
     */ // y los parametros hay que ponerlos asi siempre 
    public Pedido(Fecha fecha, Cliente cliente, LineaPedido linea1, LineaPedido linea2)    {
     this.fecha = fecha;
     this.cliente= cliente; 
     this.linea1 = linea1; // pongo this.linea1 porque es al que le asigno el valor
     this.linea2= linea2;
        
    }

    /**
     * accesor para la fecha del pedido
     */
    public int getFecha() {
         return fecha;
    }

    /**
     * accesor para el cliente
     */
    public String getCliente() {
         return cliente;
    }
    
    
    /**
     * calcular y devolver el importe total del pedido sin Iva
     */
    public double getImporteAntesIva() {
       
       double producto1 =linea1.getProducto().getPrecio() * linea1.getCantidad();
       double producto2 = linea2.getProducto().getPrecio() * linea2.getCantidad();
       double resul = producto1 + producto2;
       return resul;
         
    }

    /**
     * calcular y devolver el iva a aplicar
     */
    public  double getIva() {
        double iva = getImporteAntesIva() * IVA;
        return iva;
        
         
    }

    /**
     * calcular y devolver el importe total del pedido con Iva
     */
    public double getImporteTotal() {
         double tot = getImporteAntesIva() + getIva();
         return tot;
    }

    /**
     * Representación textual del pedido
     * (ver enunciado)
     */
    public String toString() {//*
        String str = System.out.printf("FECHA PEDIDO: ",fecha.toString());
        String str1 = System.out.printf("DATOS DEL CLIENTE: ",cliente.toString());
        
        return str + str1;
        
    }
    
    
    /**
     * devuelve true si el pedido actual es más antiguo que el recibido 
     * como parámetro
     */
    public boolean masAntiguoQue(Pedido otro) {//revisar, no me sale
        return this.fecha.antesQue(otro.getFecha());
       
        }
         
    
    
     /**
     * devuelve una referencia al pedido actual
     */
    public Pedido getPedidoActual() {
        Pedido p = new Pedido(fecha, cliente, linea1, linea2);
        return p;
    }

}
