import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

public class VehiclesImporter {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResource("random-vehicles.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(json);
        String query = "INSERT INTO VEHICLE " +
                "(ID, ARCHIVED, CHARGER_TYPE, COLOR, DAMAGED, " +
                "DEVICE_DPD, DEVICE_IMEI, DPD, ISERVE_ID, " +
                "LOCKED, PLATE_NUMBER, QR_CODE_VALUE, STATUS, " +
                "VEHICLE_YEAR, MAKE_ID, MODEL_ID) " +
                "VALUES " +
                "(VEHICLE_SEQ.NEXTVAL, 0, 'Fast Charger', 'Red', 0," +
                "'%s', '%s', '%s', '%s', " +
                "1, '%s', '%s', 0, " +
                "2010, 1, 1);\n";
        //output
        Path file = Paths.get("src/main/resources/script.txt");


        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject vehicle = jsonArray.getJSONObject(i);
            String line = String.format(query, vehicle.get("sensorTag"), vehicle.get("sensor"),
                    vehicle.get("name"), vehicle.get("assetExternalSystemId"), vehicle.get("vrn"),
                    RandomStringUtils.randomAlphanumeric(20));
            try {
                Files.write(file, line.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
        }
    }
}
