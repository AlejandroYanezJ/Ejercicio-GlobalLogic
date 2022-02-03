package globallogic.ejercicio.dto;

public class PhoneDTO {

    private Long number;
    private int citycode;
    private String contrycode;

    public PhoneDTO() {
    }

    public PhoneDTO(Long number, int citycode, String contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", citycode=" + citycode +
                ", contrycode='" + contrycode + '\'' +
                '}';
    }
}
