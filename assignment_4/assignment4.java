
interface DataAdapter<T> {
    T convert(T data);
}


class XML {
    private String data;

    public XML(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}

class Proto {
    private String data;

    public Proto(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}

class JSON {
    private String data;

    public JSON(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}

// Adapter classes
class JsonToXmlAdapter implements DataAdapter<JSON> {
    @Override
    public XML convert(JSON data) {
        String xmlData = "<xml>" + data.getData() + "</xml>";
        return new XML(xmlData);
    }
}

class XmlToJsonAdapter implements DataAdapter<XML> {
    @Override
    public JSON convert(XML data) {
        // Logic to convert XML data to JSON
        String jsonData = "{\"xml_data\": \"" + data.getData() + "\"}";
        return new JSON(jsonData);
    }
}

class ProtoToXmlAdapter implements DataAdapter<Proto> {
    @Override
    public XML convert(Proto data) {
        // Logic to convert Proto data to XML (similar to JsonToXmlAdapter)
        String xmlData = "<xml>" + data.getData() + "</xml>";
        return new XML(xmlData);
    }
}

// Client class utilizing the adapter pattern
class DataConverter<T> {
    private DataAdapter<T> adapter;

    public DataConverter(DataAdapter<T> adapter) {
        this.adapter = adapter;
    }

    public T convert(T data) {
        return adapter.convert(data);
    }
}

class Main {
    public static void main(String[] args) {
        // Usage
        DataAdapter<JSON> jsonToXmlAdapter = new JsonToXmlAdapter();
        DataConverter<JSON> client1 = new DataConverter<>(jsonToXmlAdapter);
        JSON jsonData = new JSON("{\"key\": \"value\"}");
        XML xmlData = client1.convert(jsonData);
        System.out.println("JSON to XML Data: " + xmlData);

        DataAdapter<XML> xmlToJsonAdapter = new XmlToJsonAdapter();
        DataConverter<XML> client2 = new DataConverter<>(xmlToJsonAdapter);
        XML xmlData2 = new XML("<xml><key>value</key></xml>");
        JSON jsonData2 = client2.convert(xmlData2);
        System.out.println("XML to JSON Data: " + jsonData2);

        DataAdapter<Proto> protoToXmlAdapter = new ProtoToXmlAdapter();
        DataConverter<Proto> client3 = new DataConverter<>(protoToXmlAdapter);
        Proto protoData = new Proto("proto-data");
        XML xmlData3 = client3.convert(protoData);
        System.out.println("Proto to XML Data: " + xmlData3);
    }
}
