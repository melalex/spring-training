package ua.room414;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import ua.room414.domain.entity.Auditorium;
import ua.room414.dto.AuditoriumDto;

@EntityScan(
        basePackageClasses = {SpringBookingApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class SpringBookingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookingApplication.class, args);

        ModelMapper modelMapper = context.getBean(ModelMapper.class);

        Auditorium auditorium = new Auditorium();
        auditorium.setName("sssss");

        System.out.println(modelMapper.map(auditorium, AuditoriumDto.class).getName());
    }
}
