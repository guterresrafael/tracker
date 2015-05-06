package rs.pelotas.tracker.resource;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import rs.pelotas.tracker.entity.Book;

@Path("/books")
@Produces(MediaType.APPLICATION_XML)
public class BookResource {

    @PermitAll
    @AddLinks
    @LinkResource(value = Book.class)
    @GET
    @Formatted
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book", "Author"));
        return books;
    }
}