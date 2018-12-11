package pl.put.poznan.transformer.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.RequestModel;
import pl.put.poznan.transformer.logic.TransformsManager;

import java.util.Arrays;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    private final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/{text}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        TransformsManager transformsManager = new TransformsManager(transforms);
        try{
            String json = mapper.writeValueAsString(transformsManager.applyTransformations(text));
            return ResponseEntity.ok(json);
        }
        catch (JsonProcessingException ex){
            logger.debug(ex.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @CrossOrigin(origins = "http://localhost:5000")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> post(@RequestBody RequestModel model) {
        if(model == null){
            return ResponseEntity.status(400).body("Malformed input JSON");
        }
        if(model.text == null){
            return ResponseEntity.status(400).body("Malformed text field in JSON");
        }
        if(model.transforms == null){
            return ResponseEntity.status(400).body("Malformed transforms field in JSON");
        }
        // log the parameters
        logger.debug(model.text);
        logger.debug(Arrays.toString(model.transforms));

        // do the transformation, you should run your logic here, below just a silly example
        TransformsManager transformsManager = new TransformsManager(model.transforms);
        try{
            String json = mapper.writeValueAsString(transformsManager.applyTransformations(model.text));
            return ResponseEntity.ok(json);
        }
        catch (JsonProcessingException ex){
            logger.debug(ex.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }



}


