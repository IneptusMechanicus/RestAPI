package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class InstrumentService
{
	private static InstrumentService instance;

	public static InstrumentService getInstance()
	{
		if (instance == null)
		{
			instance = new InstrumentService();
		}
		return instance;
	}

	private List<Instrument> InstrumentList = new ArrayList<>();

	public InstrumentService()
	{
		InstrumentList.add(new Instrument(1, "Guitar", "Fender", "Stratocaster", 2005, 300));
		InstrumentList.add(new Instrument(2, "Keyboard", "Casio", "CK-2200", 2010, 400));
		InstrumentList.add(new Instrument(3, "Drums", "Yamaha", "Marshal", 2002, 400));

	}

	public List<Instrument> getInstrument()
	{
		return Collections.unmodifiableList(InstrumentList);
	}

	public void addInstrument(Instrument instr)
	{
		InstrumentList.add(instr);
	}
	
	public PagedResponse getPagedFiltered(
			int page, 
			int perPage, 
			String typeFilter, 
			String brandFilter,
			String modelFilter, 
			int yearFilter, 
			int priceMin, 
			int priceMax)
	{
		
		PagedResponse response;
		List<Instrument> InstrumentPage = InstrumentList;
		long previousEntries = page * perPage;
		int totalPages = 0;
		
		if(!typeFilter.equals(""))
		{
			InstrumentPage = InstrumentPage.stream().filter(
					(u) -> (u.getType().toLowerCase())
					.equals(typeFilter.toLowerCase()))
					.collect(Collectors.toList());
		}
		
		if(!brandFilter.equals(""))
		{
			InstrumentPage = InstrumentPage.stream().filter(
					(u) -> (u.getBrand().toLowerCase())
					.equals(brandFilter.toLowerCase()))
					.collect(Collectors.toList());
		}
		
		if(!modelFilter.equals(""))
		{
			InstrumentPage = InstrumentPage.stream().filter(
					(u) -> (u.getModel().toLowerCase())
					.equals(modelFilter.toLowerCase()))
					.collect(Collectors.toList());
		}
		
		if(yearFilter != 0)
		{
			InstrumentPage = InstrumentPage.stream()
					.filter((u) -> u.getYear() == yearFilter)
					.collect(Collectors.toList());
		}
		
		if(priceMin != -1)
		{
			InstrumentPage = InstrumentPage.stream()
					.filter((u) -> u.getPrice() >= priceMin)
					.collect(Collectors.toList());
		}
		
		if(priceMax != -1)
		{
			InstrumentPage = InstrumentPage.stream()
					.filter((u) -> u.getPrice() <= priceMax)
					.collect(Collectors.toList());
		}
		
		if(perPage != 0){
			InstrumentPage = InstrumentPage.stream()
					.skip(previousEntries)
					.limit(perPage)
					.collect(Collectors.toList());
		}
		response = new PagedResponse(InstrumentPage, page, totalPages);
		return response;
	}
}
