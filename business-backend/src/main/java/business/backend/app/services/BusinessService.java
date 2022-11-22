package business.backend.app.services;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.backend.app.entities.BusinessEntry;
import business.backend.app.entities.WorkingTime;
import business.backend.app.feignClient.BusinessEntryClient;
import business.backend.app.infrastracture.Utils;

@Service
public class BusinessService implements BusinessServiceInterface {
	
	@Autowired
	private BusinessEntryClient businessEntryClient;
	
	public BusinessEntry getBusinessEntry(String id) {
		BusinessEntry businessEntry=businessEntryClient.getBusinessEntry(id);
		
		Map<String,ArrayList<WorkingTime>> days= businessEntry.getOpeningHours().getDays();
		
		LocalDateTime now = LocalDateTime.now();
		
		DayOfWeek day=now.getDayOfWeek();
		
		ArrayList<WorkingTime> workingTimes=days.get(day.toString().toLowerCase());
		LocalTime nowTime=now.toLocalTime();
		
		
		for (WorkingTime workingTime : workingTimes) {
			LocalTime startTime=workingTime.getStart();
			LocalTime endTime = workingTime.getEnd();
			if(endTime.equals(LocalTime.MIN)) endTime=LocalTime.MAX;
			if((startTime.isBefore(nowTime) || startTime.equals(nowTime)) && (endTime.isAfter(nowTime))) {		
				businessEntry.setOpen(true);
				break;
			}
		}
		
		
		Map<String,ArrayList<WorkingTime>> map= removeDuplicate(days);
		
		
		businessEntry.getOpeningHours().setDays(map);
		
		
		return businessEntry;
	}
	
	
	public Map<String, ArrayList<WorkingTime>> removeDuplicate(Map <String, ArrayList<WorkingTime>> days){
		Map<String, ArrayList<WorkingTime>> result= new HashMap<String, ArrayList<WorkingTime>>();
		Set<String> keys= days.keySet();
		Iterator<String> keyIter=keys.iterator();
		while(keyIter.hasNext()) {
			String key=keyIter.next();
			ArrayList<WorkingTime> value= days.get(key);
			if(result.containsValue(value)) {
				String key1=Utils.getKeysByValue(result, value).iterator().next();
				result.remove(key1);
				result.put(key1+" "+key, value);
				
			}else {
				result.put(key,value);
			}
		}
		return result;
	}
	

}

