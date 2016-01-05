package com.trello.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trello.model.Card;
import com.trello.model.Table;
import com.trello.model.Table.TableVisibility;
import com.trello.model.TableList;
import com.trello.service.TableServiceImpl;



@Controller
public class TableController extends AbstractController{
	@Autowired
	private TableServiceImpl tableService;
	
	private static final Logger logger = Logger.getLogger(TableController.class);
	
	@RequestMapping(value="/viewTables")
	public ModelAndView viewTables(Model model) {
		Map<String, Object> map = new HashMap();
		map.put("tables", (List<Table>)tableService.getTables());
		map.put("history", (List<String>) tableService.getHistory().getActivities());
		return new ModelAndView("tableList", map);
	}
	
	@RequestMapping(value="/getHistory")
	public ModelAndView getHistory(Model model) {
		Map<String, Object> map = new HashMap();
		map.put("history", (List<String>) tableService.getHistory().getActivities());
		map.put("tables", (List<Table>)tableService.getTables());
		return new ModelAndView("tableList", map);
	}
	
	@RequestMapping(value="/addTable")
	public String addTable(@ModelAttribute("boardName") String tableName) {
		tableService.addTable(new Table(tableName, TableVisibility.PRIVATE));
		
		if(logger.isDebugEnabled()){
			logger.debug("\"" + tableName + "\" board has been successfully added.");
		}
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/editTable/{index}", method = RequestMethod.GET)
	public String addTable(@PathVariable("index") int index) {
		tableService.editTable(index, "edytowana tablica");
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/deleteTable/{index}", method = RequestMethod.GET)
	public String deleteTable(@PathVariable("index") int index) {
		tableService.deleteTable(index);
		
		if(logger.isDebugEnabled()){
			logger.debug("Board no. " + index + " has been successfully deleted.");
		}
		return "redirect:/viewTables";
	}
	
	 @RequestMapping(value="/tablePage/{tableIndex}/{tableName}")
     public ModelAndView tablePage(Model model, @PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName) {
             Map<String, Object> map = new HashMap();
      		 map.put("history", (List<String>) tableService.getHistory().getActivities());
             map.put("lists", (List<TableList>)tableService.getTables().get(tableIndex).getLists());
             model.addAttribute("tableIndex", tableIndex);
             model.addAttribute("tableName", tableName);
             model.addAttribute("commentary", new String());
             return new ModelAndView("tablePage", map);
     }
    
     @RequestMapping(value="/addList/{tableIndex}/{tableName}", method = RequestMethod.POST)
     public String addList(@ModelAttribute("listName") String tableListName, @PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName) {
             tableService.addListToTable(tableIndex, new TableList(tableListName, tableService.getTables().get(tableIndex).getLists().size())); logger.info(tableIndex + " " + tableService.getTables().get(tableIndex).getLists().size());
             return "redirect:/tablePage/" + tableIndex + "/" + tableName;
     }     
     
	@RequestMapping(value="/editList/{tableIndex}/{listIndex}/{newName}", method = RequestMethod.GET)
	public String editList(@PathVariable("tableIndex") int tableIndex,
							@PathVariable("listIndex") int listIndex,
							@PathVariable("newName") String newListName) {
		tableService.editList(tableIndex, listIndex, newListName);
		return "redirect:/tablePage/" + tableIndex;
	}
	
	@RequestMapping(value="/deleteList/{tableIndex}/{tableName}/{listIndex}", method = RequestMethod.GET)
	public String deleteList(@PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName, @PathVariable("listIndex") int listIndex) {
		tableService.deleteList(tableIndex, listIndex);
		return "redirect:/tablePage/" + tableIndex + "/" + tableName;
	}
	
	 @RequestMapping(value="/addCard/{tableIndex}/{tableName}/{listIndex}", method = RequestMethod.POST)
     public String addCard(@ModelAttribute("cardName") String cardName,
    		 			   @PathVariable("tableIndex") int tableIndex,
    		 			   @PathVariable("tableName") String tableName,
    		 			   @PathVariable("listIndex") int listIndex) {
          tableService.addCardToList(tableIndex, listIndex, new Card(cardName, listIndex));
          return "redirect:/tablePage/" + tableIndex + "/" + tableName;
     }
     
	 @RequestMapping(value="/editCard/{tableIndex}/{listIndex}/{cardIndex}/{newName}", method = RequestMethod.GET)
	 public String editCard(@PathVariable("tableIndex") int tableIndex,
							@PathVariable("listIndex") int listIndex,
							@PathVariable("cardIndex") int cardIndex,
							@PathVariable("newName") String newName) {
		 tableService.editCard(tableIndex, listIndex, cardIndex, newName);
		 return "redirect:/tablePage/" + tableIndex;
	 }
	
	 @RequestMapping(value="/deleteCard/{tableIndex}/{listIndex}/{cardIndex}/{tableName}", method = RequestMethod.GET)
	 public String deleteCard(@PathVariable("tableIndex") int tableIndex,
			 				  @PathVariable("listIndex") int listIndex,
			 				  @PathVariable("cardIndex") int cardIndex,
			 				  @PathVariable("tableName") String tableName) {
		 tableService.deleteCard(tableIndex, listIndex, cardIndex);
		 return "redirect:/tablePage/" + tableIndex + "/" + tableName;
	 }
	
	 @RequestMapping(value="/addComment/{tableIndex}/{tableName}/{listIndex}/{cardIndex}", method = RequestMethod.POST)
     public String addComment(@ModelAttribute("commentary") String commentary, @PathVariable("tableIndex") int tableIndex,
    		 			   @PathVariable("tableName") String tableName,
    		 			   @PathVariable("listIndex") int listIndex,
    		 			   @PathVariable("cardIndex") int cardIndex) {
          tableService.addComment(tableIndex, listIndex, cardIndex, commentary);
          return "redirect:/tablePage/" + tableIndex + "/" + tableName;
     }
     
	 @RequestMapping(value="/editComment/{tableIndex}/{listIndex}/{cardIndex}/{commentIndex}/{newName}", method = RequestMethod.GET)
	 public String editComment(@PathVariable("tableIndex") int tableIndex,
								@PathVariable("listIndex") int listIndex,
								@PathVariable("cardIndex") int cardIndex,
								@PathVariable("commentIndex") int commentIndex,
								@PathVariable("newName") String newName) {
		 tableService.editComment(tableIndex, listIndex, cardIndex, commentIndex, newName);
		 return "redirect:/tablePage/" + tableIndex;
	 }
	
	 @RequestMapping(value="/deleteComment/{tableIndex}/{listIndex}/{cardIndex}/{commentIndex}/{tableName}", method = RequestMethod.GET)
	 public String deleteComment(@PathVariable("tableIndex") int tableIndex,
				 				  @PathVariable("listIndex") int listIndex,
				 				  @PathVariable("cardIndex") int cardIndex,
				 				  @PathVariable("commentIndex") int commentIndex,
				 				  @PathVariable("tableName") String tableName) {
		 tableService.deleteComment(tableIndex, listIndex, cardIndex, commentIndex);
		 return "redirect:/tablePage/" + tableIndex + "/" + tableName;
	 }
/*
	 @RequestMapping(value="/upload/{tableIndex}/{tableName}/{listIndex}/{cardIndex}", method=RequestMethod.POST)
	    public ModelAndView handleFileUpload(@PathVariable("tableIndex") int tableIndex,
											  @PathVariable("listIndex") int listIndex,
											  @PathVariable("cardIndex") int cardIndex,
											  @PathVariable("tableName") String tableName,
											  @RequestParam("name") String fileName,
					   						  @RequestParam("file") MultipartFile file) {					 
		    if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                File uploadedFile = new File(fileName);
	                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
	                stream.write(bytes);
	                stream.close();	                
	            	tableService.addFile(uploadedFile, tableIndex, listIndex, cardIndex);
	                logger.debug("You successfully uploaded " + fileName + "!");
	            } catch (Exception e) {
	            	logger.debug("You failed to upload " + fileName + " => " + e.getMessage());
	            }
	        } else {
	        	logger.debug("You failed to upload " + fileName + " because the file was empty.");
	        }
		    
		    Map<String, Object> map = new HashMap();
			map.put("file_names", (List<String>) tableService.getFileNames(tableIndex, listIndex, cardIndex));
		    return new ModelAndView("redirect:/tablePage/" + tableIndex + "/" + tableName, map);
	 }

	 @RequestMapping(value="/getUploadedFileNames/{tableIndex}/{tableName}/{listIndex}/{cardIndex}")
	 public ModelAndView getUploadedFileNames(@PathVariable("tableIndex") int tableIndex,
											  @PathVariable("listIndex") int listIndex,
											  @PathVariable("cardIndex") int cardIndex,
											  @PathVariable("tableName") String tableName) {
		 Map<String, Object> map = new HashMap();
		 map.put("file_names", (List<String>) tableService.getFileNames(tableIndex, listIndex, cardIndex));
		 return new ModelAndView("redirect:/tablePage/" + tableIndex + "/" + tableName, map);
	 }*/
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "hello world");
		
		return model;
	}
}

