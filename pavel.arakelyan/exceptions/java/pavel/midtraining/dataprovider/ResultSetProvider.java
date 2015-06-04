package pavel.midtraining.dataprovider;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class that provides dummy result set
 */
public class ResultSetProvider {

    private ResultSet mockResultSet;

    public ResultSetProvider(){
        mockResultSet = mock(ResultSet.class);
    }

    /**
     * Provides result under specified row index
     * @param index row index
     * @return dummy result set
     * @throws SQLException on invalid index
     */
    public ResultSet getResult(int index) throws SQLException{
        if(index < 1){
            throw new SQLException("Row with " + index + " index does not exist");
        }
        setExpectation();
        return mockResultSet;
    }

    private void setExpectation() throws SQLException{
        when(mockResultSet.getString("name")).thenReturn("resource_name");
        when(mockResultSet.getInt("capacity")).thenReturn(10);
    }

}
