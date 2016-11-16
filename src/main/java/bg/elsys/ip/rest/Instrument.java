package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Instrument {
	
	@ApiModelProperty(required = true)
	private int id;
	
	@ApiModelProperty(value = "This will show the type of instrument", example = "Guitar")
	private String instrument;
	
	@ApiModelProperty(value = "This will show the instrument brand", example = "Fender")
	private String brand;
	
	@ApiModelProperty(value = "This will show the instrument model", example = "Stratocaster")
	private String model;
	
	@ApiModelProperty(value = "This will show the instrument serial number", example = "1324145635")
	private int serialNumber;

	public Instrument() {
	}

	public Instrument(int id, String instrument, String brand, String model, int serialNumber) {
		super();
		this.id = id;
		this.setInstrument(instrument);
		this.setBrand(brand);
		this.setModel(model);
		this.setSerialNumber(serialNumber);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
}
