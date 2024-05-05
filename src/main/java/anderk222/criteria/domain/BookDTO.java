package anderk222.criteria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDTO {

    private Long id;

    private String name;

    @JsonFormat(pattern = "YYYY-mm-dd")
    private LocalDate year;

    private BigDecimal price;

    public Book toEntity() {

        return Book.builder()
                .id(this.getId())
                .name(this.getName())
                .year(this.getYear())
                .price(this.getPrice())
                .build();

    }
}
