package com.trello.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.trello.service.TableServiceImpl;

@Controller
public class FileUploadController {
	@Autowired
	private TableServiceImpl tableService;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(value = "/upload/{tableIndex}/{tableName}/{listIndex}/{cardIndex}", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadFileHandler(@PathVariable("tableIndex") int tableIndex,
			  @PathVariable("listIndex") int listIndex,
			  @PathVariable("cardIndex") int cardIndex,
			  @PathVariable("tableName") String tableName,
			  @RequestParam("name") String name,
			  @RequestParam("file") MultipartFile file) {
 
        if (!file.isEmpty()) {
            try {
            	
                byte[] bytes = file.getBytes(); 
                File dir = new File(name);
                
                if (!dir.exists()){
                	
                	dir.mkdirs();
                }               	
 
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                logger.info("Server File Location=" + serverFile.getAbsolutePath());
 
                logger.debug("You successfully uploaded " + name + "!");
            } catch (Exception e) {
            	
            	logger.debug("You failed to upload " + name + " => " + e.getMessage());
            	
            }
        } else {
        	
        	logger.debug("You failed to upload " + name + " => " + " because the file was empty.");
        	
        }
        
        Map<String, Object> map = new HashMap();
		map.put("file_names", (List<String>) tableService.getFileNames(tableIndex, listIndex, cardIndex));
	    return new ModelAndView("redirect:/tablePage/" + tableIndex + "/" + tableName, map);
    }

}
