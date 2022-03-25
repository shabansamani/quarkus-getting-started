package tech.shaban.udemy;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.netty.util.internal.StringUtil;

@Path("/book")
public class BookResource {
    
    private static List<String> books = new ArrayList<>();

    static {
        books.add("The Freelancer's Bible");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {

        return StringUtil.join(",", books).toString();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String body) {
        books.add(body);
        return books.toString();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBook(@PathParam("id") Integer index, String book) {
        books.remove((int) index);
        books.add(index, book);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@PathParam("id") Integer index) {
        return books.remove((int) index);
    }
}
