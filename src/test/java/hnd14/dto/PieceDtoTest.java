package hnd14.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import hnd14.dto.enums.PieceType;
import hnd14.dto.enums.Side;

public class PieceDtoTest {
    @Test
    void test_builderAndEquals(){
        // Record can be generated with a constructor with all arguments
        var dto1 = new PieceDto(Side.BLACK, PieceType.PAWN, "E2");
        // Thanks to lombok builder annotation, we can also construct a record with a builder
        var dto2 = PieceDto.builder().side(Side.BLACK).type(PieceType.PAWN).position("E2").build();

        // Two records with all equal fields are equal
        assertThat(dto1).isEqualTo(dto2);
    }
    
    @Test
    void test_getter() {
        var dto = PieceDto.builder().side(Side.BLACK).type(PieceType.PAWN).position("E2").build();

        // We can access record fields through getters 
        assertThat(dto.position()).isEqualTo("E2");
        assertThat(dto.side()).isEqualTo(Side.BLACK);
        assertThat(dto.type()).isEqualTo(PieceType.PAWN);
    }


    @Test
    void test_toBuilder(){
        // toBuilder is a way to create a new record based on an existing record
        var dto1 = PieceDto.builder().side(Side.BLACK).type(PieceType.PAWN).position("E2").build();
        var dto2 = dto1.toBuilder().position("G5").build();

        // The field provided to the builder is set to the latest value
        assertThat(dto2.position()).isEqualTo("G5");
        // The other fields will stay the same
        assertThat(dto2.side()).isEqualTo(dto1.side());
        assertThat(dto2.type()).isEqualTo(dto1.type());
        // The source dto still remains the same
        assertThat(dto1.position()).isEqualTo("E2");
    }
}
