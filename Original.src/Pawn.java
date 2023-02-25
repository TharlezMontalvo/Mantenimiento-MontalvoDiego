import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Pawn extends ChessGamePiece {
    private boolean notMoved;

    public Pawn(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, true);
        notMoved = true;
        possibleMoves = calculatePossibleMoves(board);
    }

    @Override
    public boolean move(ChessGameBoard board, int row, int col) {
        if (super.move(board, row, col)) {
            notMoved = false;
            possibleMoves = calculatePossibleMoves(board);
            if ((getColorOfPiece() == ChessGamePiece.BLACK && row == 7) || (getColorOfPiece() == ChessGamePiece.WHITE && row == 0)) {
                board.getCell(row, col).setPieceOnSquare(createPromotedPiece(board, row, col, getColorOfPiece()));
            }
            return true;
        }
        return false;
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<>();
        if (isPieceOnScreen()) {
            int currRow = getColorOfPiece() == ChessGamePiece.WHITE ? (pieceRow - 1) : (pieceRow + 1);
            int count = 1;
            int maxIter = notMoved ? 2 : 1;

            while (count <= maxIter && isOnScreen(currRow, pieceColumn) && isCellEmpty(board, currRow, pieceColumn)) {
                moves.add(currRow + "," + pieceColumn);
                currRow = getColorOfPiece() == ChessGamePiece.WHITE ? (currRow - 1) : (currRow + 1);
                count++;
            }
            addCaptureMoves(board, moves);
        }
        return moves;
    }

    private boolean isCellEmpty(ChessGameBoard board, int currRow, int pieceColumn) {
        return false;
    }

    private void addCaptureMoves(ChessGameBoard board, ArrayList<String> moves) {
        int[] rowOffsets = { -1, -1, 1, 1 };
        int[] colOffsets = { -1, 1, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int row = pieceRow + rowOffsets[i];
            int col = pieceColumn + colOffsets[i];
            if (isOnScreen(row, col) && isEnemy(board, row, col)) {
                moves.add(row + "," + col);
            }
        }
    }

    private ChessGamePiece createPromotedPiece(ChessGameBoard board, int row, int col, int color) {
        return new Queen(board, row, col, color);
    }

    @Override
    public ImageIcon createImageByPieceType() {
        String fileName = "default-Unassigned.gif";
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            fileName = "WhitePawn.gif";
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            fileName = "BlackPawn.gif";
        }
        return new ImageIcon(getClass().getResource("chessImages/" + fileName));
    }
}