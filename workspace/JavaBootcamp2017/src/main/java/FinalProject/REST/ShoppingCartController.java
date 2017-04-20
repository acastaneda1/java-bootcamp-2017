package FinalProject.REST;

import java.util.LinkedList;
import java.util.List;
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

import FinalProject.Services.ShoppingCartAPI;
import FinalProject.Entities.ItemBag;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

	ShoppingCartAPI cartService;

	@Autowired
	public ShoppingCartController(ShoppingCartAPI cartService) {
		this.cartService = cartService;
	}
	
	ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET, value = "id/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getItems(@PathVariable("cartId") Integer id) throws JsonProcessingException {
		
    	LinkedList<ItemBag> items = cartService.getItems(id);
    	if(items == null){
    		return new ResponseEntity<>("No product found for ID " + id, HttpStatus.NOT_FOUND);
    	} else { 
    		if(items.isEmpty())
    			return new ResponseEntity<>("The cart is empty", HttpStatus.OK);
    		else
    			return new ResponseEntity<>(items, HttpStatus.OK);
    	}
	}

}
