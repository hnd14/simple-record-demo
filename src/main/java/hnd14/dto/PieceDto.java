package hnd14.dto;

import hnd14.dto.enums.PieceType;
import hnd14.dto.enums.Side;
import lombok.Builder;

@Builder(toBuilder = true)
public record PieceDto(Side side,
            PieceType type,
            String position
) {}
