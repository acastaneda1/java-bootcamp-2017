package FinalProject.REST;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import FinalProject.Entities.Item;
import FinalProject.Services.ProductService;


@RestController
@RequestMapping("/{product}")
public class ProductController {

	@Autowired
	ProductService item;

	ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET, value = "/items", produces = MediaType.APPLICATION_JSON)

    public ResponseEntity<?> getItems(@PathVariable("productId") Integer id) throws JsonProcessingException {
		
    	Item items = item.getItem(id);
    	if(items == null){
    		return new ResponseEntity("No product found for ID " + id, HttpStatus.NOT_FOUND);
    	} else {
    		return new ResponseEntity(items, HttpStatus.OK);
    	}
	}

}
