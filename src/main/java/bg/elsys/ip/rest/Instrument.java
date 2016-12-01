package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Instrument
{

	@ApiModelProperty(required = true)
	private int id;

	@ApiModelProperty(value = "This will show the type of instrument", example = "Guitar")
	private String type;

	@ApiModelProperty(value = "This will show the instrument brand", example = "Fender")
	private String brand;

	@ApiModelProperty(value = "This will show the instrument model", example = "Stratocaster")
	private String model;
	
	@ApiModelProperty(value = "This will show the instrument model", example = "Stratocaster")
	private int year;

	@ApiModelProperty(value = "This will show the instrument serial number", example = "200")
	private int price;

	public Instrument()
	{
	}

	public Instrument(int id, String instrument, String brand, String model, int year, int price)
	{
		super();
		this.setId(id);
		this.setType(instrument);
		this.setBrand(brand);
		this.setModel(model);
		this.setYear(year);;
		this.setPrice(price);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int serialNumber)
	{
		this.price = serialNumber;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}
}
