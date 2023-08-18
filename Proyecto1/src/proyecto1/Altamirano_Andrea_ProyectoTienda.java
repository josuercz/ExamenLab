package proyecto1;
import java.util.Scanner;

public class Altamirano_Andrea_ProyectoTienda {
    public static void main(String[] args){
try{
    Scanner leer=new Scanner (System.in);
    leer.useDelimiter("\n");
    
    int opcion=0,entradaCaja=0,codigoProductoVenta,codigoProductoCompra,contadorCompras=0,contadorVentas=0,contadorAzucar=0,contadorAvena=0,contadorTrigo=0,contadorMaiz=0;
    double efectivoInicial,sumaEfectivoCaja=0,precioVenta=0,precioCompra=0,azucarKG=0,avenaKG = 0,trigoKG=0,maizKG=0,almacen=0,volumenVentas=0,volumenCompras=0,mayorGanancia=0,gastoCompra = 0,mayorGasto=0;
    String tipoCliente,productoVenta="",nuevaCompra ,factura="",tipoProveedor = "",respuestaCaja="SI",productoCompra="",productoEstrella="";
    double ventaKilogramos,compraKilogramos,totalCompra=0,subtotalVenta=0,descuentoVenta=0,subtotalVentaTotal=0,totalVenta=0,descuentoVentaTotal,impuesto,acumuladorCompra=0,acumuladorVentas=0
            ,depositoBanco,ganancia,contadorEstrella=0;
    boolean compra=true,abrirCaja=false;
    //Repetidor hasta llegar a la opcion de salir de sistema    
    while(opcion!=6){
            
        System.out.println("-----BIENVENIDO A TIENDA JAVA-----\n---------------MENÚ---------------\nElija el número de la acción que desea realizar\n1. Abrir caja\n2. Ventas\n3. Compras\n4. Reportes\n5. Cierre de caja\n6. Salir del sistema");
    opcion=leer.nextInt();
    while (opcion>6||opcion<1){
        System.out.println("Opción no valida, vuelva a intertarlo con las opciones mostradas en pantalla (1/2/3/4/5/6)");
        opcion=leer.nextInt();
    }
    
   //Abrir caja
    if (opcion==1){
        //Ingreso de efectivo a caja
                abrirCaja=true;
                System.out.println("================================================\n------------------ABRIR CAJA--------------------\nEfectivo actual: Lps. "+sumaEfectivoCaja+"\n------------------------------------------------");
                if(entradaCaja>0){
                System.out.println("¿Desea ingresar efectivo a caja?");
                respuestaCaja=leer.next().toUpperCase();
                if (respuestaCaja.toUpperCase().equals("NO")){
                    continue;
                }
                }
                if (sumaEfectivoCaja==0||respuestaCaja.toUpperCase().equals("SI")){
                System.out.print("Ingrese la cantidad de efectivo que desea guardar en caja: Lps. ");
                efectivoInicial=leer.nextDouble();
                //Repetidor de pregunta con restriccion
                while (efectivoInicial<1){
                    System.out.println("Valor no válido, inténtelo de nuevo");
                    efectivoInicial=leer.nextDouble();
                }
                
                sumaEfectivoCaja+=efectivoInicial;
                System.out.println("=============================================================\nIngreso realizado con éxito, el monto agregado es de Lps. "+efectivoInicial+"\nEl monto total actual es de: Lps. "+sumaEfectivoCaja+"\n=============================================================\n");
                //acumulador y contador de caja (opcion 1)
    }
                entradaCaja++;
    }
    
    
    if (abrirCaja){ 
        //VENTAS
            if (opcion==2){
                if(avenaKG>0||azucarKG>0||trigoKG>0||maizKG>0){

                System.out.println("----------------------------VENTAS----------------------------\nIngrese la letra del tipo de cliente que es:\nTipo A\nTipo B\nTipo C\n--------------------------------------------------------------");
                tipoCliente=leer.next().toUpperCase();
                //restriccion de tipo cliente
                while(!tipoCliente.toUpperCase().equals("A")&&!tipoCliente.toUpperCase().equals("B")&&!tipoCliente.toUpperCase().equals("C")){
                System.out.println("Tipo de cliente inexistente, vuelva a intentarlo con una de las opciones mostradas en pantalla");
                tipoCliente=leer.next().toUpperCase();
                }
                //condicion de pregunta
                while (compra=true){
                System.out.println("----------------------------------\n|  Código  | Producto |  Precio  |\n==================================\n----------------------------------");
                System.out.println("|    1     |  Azúcar  |  Lps. 30 |");
                System.out.println("|    2     |  Avena   |  Lps. 25 |");
                System.out.println("|    3     |  Trigo   |  Lps. 32 |");
                System.out.println("|    4     |   Maíz   |  Lps. 20 |\n==================================\nElija el código del producto que desea comprar");
                codigoProductoVenta=leer.nextInt();
                //restriccion de codigos
                while(codigoProductoVenta!=1&&codigoProductoVenta!=2&&codigoProductoVenta!=3&&codigoProductoVenta!=4){
                System.out.println("Código inexistente, vuelva a intentarlo");
                codigoProductoVenta=leer.nextInt();
                    }
                //restricciones cliente tipo b
                if (tipoCliente.toUpperCase().equals("B")){
                    while(codigoProductoVenta!=1&&codigoProductoVenta!=2&&codigoProductoVenta!=3){
                        System.out.println("------------------------------------\n¡No puede comprar dicho producto!\n------------------------------------");
                        break;
                    }
                    
                }
                //restriccion cliente tipo C
                if (tipoCliente.toUpperCase().equals("C")){
                    while(codigoProductoVenta!=4){
                    System.out.println("------------------------------------\n¡No puede comprar dicho producto!\n------------------------------------");
                    break;
                    }   
                }
                if((tipoCliente.toUpperCase().equals("C")&&codigoProductoVenta==4)||(tipoCliente.toUpperCase().equals("B")&&(codigoProductoVenta==1||codigoProductoVenta==2||codigoProductoVenta==3))||(tipoCliente.toUpperCase().equals("A")&&(codigoProductoVenta==1||codigoProductoVenta==2||codigoProductoVenta==3||codigoProductoVenta==4))){
      //Datos de codigos con producto, precio e inventario  
                    System.out.println("""
                                       ----------------------Tabla de descuentos----------------------
                                       Subtotal mayor o igual a Lps. 1,000 --> 5% sobre el subtotal
                                       Subtotal mayor a Lps. 5,000         --> 10% sobre el subtotal
                                       Subtotal menor a Lps. 1,000         --> No aplica descuento
                                       -------------------------------------------------------------
                                       """);
    switch (codigoProductoVenta) {
        case 1 -> {
            productoVenta="Azúcar";
            precioVenta=30;
            almacen=azucarKG;
            precioCompra=25;
            
        }
        case 2 -> {
            productoVenta="Avena";
            precioVenta=25;
            almacen=avenaKG;
            if(tipoProveedor.toUpperCase().equals("B")){
               precioCompra=20;
            }else if(tipoProveedor.toUpperCase().equals("C")){
                precioCompra=22;
            }
            
        }
        case 3 -> {
            productoVenta="Trigo";
            precioVenta=32;
            almacen=trigoKG;
            precioCompra=30;
            
        }
        case 4 -> {
            productoVenta="Maíz";
            precioVenta=20;
            almacen=maizKG;
            precioCompra=18;
            
        }
        default -> {
        }
    }
                
                System.out.println("El producto elegido es \""+productoVenta+"\" y su precio es de Lps."+precioVenta+" por kilogramo"
                        +"\nIngrese cuantos kilogramos de dicho producto desea");
                ventaKilogramos = leer.nextDouble();
                
                
                if(codigoProductoVenta==1){
                    if (azucarKG>=ventaKilogramos){
                       azucarKG-=ventaKilogramos;
                        }
                     contadorAzucar+=ventaKilogramos;
                    if(contadorAzucar>contadorEstrella){
                       
                        contadorEstrella=contadorAzucar;
                        productoEstrella="Azúcar";
                    }
                }
                if(codigoProductoVenta==2){
                    if (avenaKG>=ventaKilogramos){
                       avenaKG-=ventaKilogramos;
                        }
                    contadorAvena+=ventaKilogramos;
                    if(contadorAvena>contadorEstrella){
                    contadorEstrella=contadorAvena;
                    productoEstrella="Avena";
                    }
                }
                if(codigoProductoVenta==3){
                    if (trigoKG>=ventaKilogramos){
                       trigoKG-=ventaKilogramos;
                        }
                    contadorTrigo+=ventaKilogramos;
                    if(contadorTrigo>contadorEstrella){
                        contadorEstrella=contadorTrigo;
                        productoEstrella="Trigo";
                }
                }
                if(codigoProductoVenta==4){
                    if (maizKG>=ventaKilogramos){
                       maizKG-=ventaKilogramos;
                        }
                    contadorMaiz+=ventaKilogramos;
                    if(contadorMaiz>contadorEstrella){
                        contadorEstrella=contadorMaiz;
                        productoEstrella="Maiz";
                    }
                        
                }
                if(almacen<ventaKilogramos){
                    System.out.println("No se cuenta con la cantidad de producto que desea");
                    
                }else{
                    subtotalVenta=precioVenta*ventaKilogramos;
                    factura=factura.concat(productoVenta+" (Lps. "+precioVenta+" por kg) ("+ventaKilogramos+" kg.) (Subtotal individual: Lps."+subtotalVenta+")\n");
                    subtotalVentaTotal+=subtotalVenta;
                    gastoCompra+=precioCompra*ventaKilogramos;
                    volumenVentas+=ventaKilogramos;
                } 
                if (subtotalVenta>=1000){
                   descuentoVenta=0.05;
                }else if(subtotalVenta>5000){
                    descuentoVenta=0.10;
                }
                }
                System.out.println("¿Desea realizar otra compra?(Si/No)");
                nuevaCompra=leer.next();
                while(!nuevaCompra.toUpperCase().equals("SI")&&!nuevaCompra.toUpperCase().equals("NO")){
                    System.out.println("Respuesta no válida, ingrese si o no.");
                    nuevaCompra=leer.next();
                }
                
                if (nuevaCompra.toUpperCase().equals("NO")){
                    
                    compra=false;
                    break;
                 }
                }
                
                impuesto=subtotalVentaTotal*0.07;
                descuentoVentaTotal=subtotalVentaTotal*descuentoVenta;
                totalVenta=subtotalVentaTotal-descuentoVenta+impuesto;
                
                if(totalVenta>0){
                    contadorVentas++;
                }
                System.out.println("""
                                   ======================================
                                                   Factura                  
                                   --------------------------------------
                                   Detalles de venta:
                                   """+factura
                        + "\nSubtotal: Lps. "+subtotalVentaTotal
                        + "\nDescuento ("+(descuentoVenta*100)+"%): -Lps. "+descuentoVentaTotal
                        + "\nImpuesto del 7%: Lps. "+impuesto
                        + "\nTotal: "+totalVenta
                        + "\n======================================");
                if(mayorGanancia<(totalVenta-gastoCompra)){
               mayorGanancia=totalVenta-gastoCompra; 
            }
            
            }else{
                    System.out.println("Debe comprar producto para poder vender");
                }
            }
            factura="";
            subtotalVentaTotal=0;
            acumuladorVentas+=totalVenta;
            sumaEfectivoCaja+=totalVenta;
            totalVenta=0;
            gastoCompra=0;
    //COMPRAS
                if (opcion==3){//opcion 3 compras
                    //Ingreso tipo de proveedor
                System.out.println("-------------------COMPRAS--------------------\nIngrese la letra del tipo de proveedor que es:\nTipo A\nTipo B\nTipo C\n----------------------------------------------");
                tipoProveedor=leer.next().toUpperCase();
                //Restriccion tipo de proveedores
                while(!tipoProveedor.toUpperCase().equals("A")&&!tipoProveedor.toUpperCase().equals("B")&&!tipoProveedor.toUpperCase().equals("C")){
                System.out.println("Tipo de proveedor inexistente, vuelva a intentarlo con una de las opciones mostradas en pantalla");
                tipoProveedor=leer.next().toUpperCase();
                }
                //eleccion de producto
                System.out.println("---------------------------------------------------\n|  Código  | Producto |    Precio por kilogramo   |\n===================================================\n---------------------------------------------------");
                System.out.println("|    1     |  Azúcar  |          Lps. 25          |");
                System.out.println("|    2     |  Avena   |  (B)->Lps. 20 (C)->Lps. 22|");
                System.out.println("|    3     |  Trigo   |          Lps. 30          |");
                System.out.println(  "|    4     |   Maíz   |          Lps. 18          |\n===================================================\nElija el código del producto que desea comprar");
                codigoProductoCompra=leer.nextInt();
                
                while(codigoProductoCompra!=1&&codigoProductoCompra!=2&&codigoProductoCompra!=3&&codigoProductoCompra!=4){
                System.out.println("Código inexistente, vuelva a intentarlo");
                codigoProductoCompra=leer.nextInt();
                }
                
     if((tipoProveedor.toUpperCase().equals("A")&&(codigoProductoCompra==1||codigoProductoCompra==4))||(tipoProveedor.toUpperCase().equals("B")&&(codigoProductoCompra==2||codigoProductoCompra==3))||(tipoProveedor.toUpperCase().equals("C")&&codigoProductoCompra==2)){
                //datos de producto
    switch (codigoProductoCompra) {
        case 1 -> {
            productoCompra="Azúcar";
            precioCompra=25;
        }
        case 2 -> {
            productoCompra="Avena";
            if (tipoProveedor.equals("B")){
            precioCompra=20;
            }
            if (tipoProveedor.equals("C")){
            precioCompra=22;
            }
        }
        case 3 -> {
            productoCompra="Trigo";
            precioCompra=30;
        }
        case 4 -> {
            productoCompra="Maíz";
            precioCompra=18;
        }
        default -> {
        }
    }
            //calculos
            System.out.println("El producto elegido es "+productoCompra+" y su precio es de Lps."+precioCompra);
            System.out.print("Ingrese cuantos kilogramos de dicho producto desea: ");
            compraKilogramos = leer.nextDouble(); 
            totalCompra=precioCompra*compraKilogramos;  
     //Factura de compras       
    if (totalCompra<=sumaEfectivoCaja){
        
        System.out.println("""
                           ======================================
                                           Factura                  
                           --------------------------------------
                           Detalles de venta:
                           """+productoCompra
                        + "\nCantidad: "+compraKilogramos+" kg."
                        + "\nPrecio: Lps. "+precioCompra+" por kg."
                        + "\nTotal: "+totalCompra
                        + "\n===================================");
        
        //Actualizar valores de inventario
    if(codigoProductoCompra==1){
        azucarKG+=compraKilogramos;
    }
    if(codigoProductoCompra==2){
        avenaKG+=compraKilogramos;
    }
    if(codigoProductoCompra==3){
        trigoKG+=compraKilogramos;
    }
    if(codigoProductoCompra==4){
        maizKG+=compraKilogramos;
    }
    if(mayorGasto<totalCompra){
        mayorGasto=totalCompra;
    }
    volumenCompras+=compraKilogramos;             
    contadorCompras++;
    }else{
        System.out.println("**No se puede pagar la compra**");
        totalCompra=0;
    }
                 
    }else{
         System.out.println("**Proveedor no vende dicho producto**");
     }
                }
                acumuladorCompra+=totalCompra;
                sumaEfectivoCaja-=totalCompra;
                totalCompra=0;
                
                
    if (opcion==4){
        
        if(productoEstrella.equals("")){
            productoEstrella="No hay producto estrella";
        }
        ganancia=acumuladorVentas-acumuladorCompra;
        if(ganancia<0){
           ganancia=0; 
        }
        System.out.println("""
                           -------------------REPORTES--------------------
                           Cantidad actual en caja:                    Lps. """+sumaEfectivoCaja
                         + "\n----Compras----"
                         + "\nNúmero de compras efectuadas en el día      #"+contadorCompras
                         + "\nVolumen total de compras del día:           "+volumenCompras+" kg. - Lps."+acumuladorCompra
                         + "\nValor medio de compras:                     Lps. "+(acumuladorCompra/contadorCompras)
                         + "\nCompra con mayor gasto:                     Lps. "+mayorGasto
                         + "\n----Ventas----"
                         + "\nNúmero de ventas en el día:                 #"+contadorVentas
                         + "\nVolumen total de ventas del día:            "+volumenVentas+" kg. - Lps."+acumuladorVentas  
                         + "\nMargen de ganancia obtenido de las ventas:  Lps. "+ganancia
                         + "\nValor medio de ventas:                      Lps. "+(acumuladorVentas/contadorVentas)
                         + "\nProducto estrella:                          "+productoEstrella+" (Kg vendidos-> "+contadorEstrella+" kg.)"
                         + "\n----Inventario----"
                         + "\nAzúcar:                                     "+azucarKG+" kg."
                         + "\nAvena:                                      "+avenaKG+" kg."
                         + "\nTrigo:                                      "+trigoKG+" kg."
                         + "\nMaíz:                                       "+maizKG+" kg."
                         + "\n---------------------------------------------");
        
       /*
        Cantidad actual de dinero
        numero de compras y de ventas (se actualiza a 0 cuando se cierra caja)
        volumen total de compras y ventas (se actualiza a 0 cuando se cierra caja)
        mostrar margen de ganancia
        promedio de compra y venta
        venta con mayor ganancia
        compras mas cara
        producto mas vendido (producto estrella)
        enter para regresar al menu
        
        */
        
    }
    if(opcion==5){
        System.out.println("-------------------CIERRE DE CAJA--------------------");
        abrirCaja=false;
        System.out.println("Total en caja: Lps. "+sumaEfectivoCaja);
        System.out.println("¿Cuánto desea depositar en el banco?\n**Tomar en cuenta que no se puede depositar más del 60%**");
        depositoBanco=leer.nextDouble();
        while(depositoBanco<1){
            System.out.println("Error, vuelva a intentarlo");
          depositoBanco=leer.nextDouble();  
        }
        while (depositoBanco>(sumaEfectivoCaja*0.6)){
            System.out.println("El valor se excede del límite que se puede depositar, vuelva a intentarlo");
            depositoBanco=leer.nextDouble();
        }
        sumaEfectivoCaja-=depositoBanco;
        System.out.println("¡Depósito realizado con éxito, su restante en caja es de Lps. "+sumaEfectivoCaja);
        contadorCompras=0;
        contadorVentas=0;
        volumenCompras=0;
        volumenVentas=0;
        ganancia=0;
        acumuladorVentas=0;
        acumuladorCompra=0;
        mayorGasto=0;
        productoEstrella="";
        contadorEstrella=0;
        /*
        cierre de caja
        total de ganancia del dia en caja(se actualiza)
        cuanto se deposita en el banco (60% es el maximo que se puede depositar)
        el resto se mantiene en caja(no se actualiza)
        cuando se cierra ya no se puede comprar ni vender
        en abrir caja hacer condicional de que si hay dinero o el contador es 1 no pida ingresar dinero como al comienzo
        */        
    }
    }else if (!abrirCaja&&opcion<6){
        System.out.println("¡Debe abrir caja para poder ingresar a las demás opciones!");

    }
    if(opcion==4&&!abrirCaja&&entradaCaja>0){
    System.out.println("""
                           -------------------REPORTES--------------------
                           Cantidad actual en caja:                    Lps. """+sumaEfectivoCaja
                         + "\n----Inventario----"
                         + "\nAzúcar:                                     "+azucarKG+" kg."
                         + "\nAvena:                                      "+avenaKG+" kg."
                         + "\nTrigo:                                      "+trigoKG+" kg."
                         + "\nMaíz:                                       "+maizKG+" kg."
                         + "\n---------------------------------------------");
    }
    }
}
    catch (Exception e){
        System.out.println("Error.");
        
    }
    }
}
    
        
   
  



