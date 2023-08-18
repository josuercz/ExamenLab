
package examenlab;
//Nicole

import java.util.Calendar;

public final class Comment {
    private int postId;
    private String autor,comentario;
    private Calendar fecha;
    
    public Comment(int postId,String autor,String comentario){
        this.postId=postId;
        this.autor=autor;
        this.comentario=comentario;
        fecha=Calendar.getInstance();
    }
    
    public String print(){
        return autor+"-"+fecha+"\nComentario: "+comentario;
    }
    
    
}
