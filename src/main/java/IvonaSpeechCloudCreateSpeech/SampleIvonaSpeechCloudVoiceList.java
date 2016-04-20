package IvonaSpeechCloudCreateSpeech;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.ListVoicesRequest;
import com.ivona.services.tts.model.ListVoicesResult;
import com.ivona.services.tts.model.Voice;

/**
 * Class with sample voice list usage.
 * Shows how to display all voices and how to filter voice list.
 */
public class SampleIvonaSpeechCloudVoiceList {

    static IvonaSpeechCloudClient speechCloud;

    private static void init() {
        speechCloud = new IvonaSpeechCloudClient(
                new ClasspathPropertiesFileCredentialsProvider("IvonaCredentials.properties"));
        speechCloud.setEndpoint("https://tts.eu-west-1.ivonacloud.com");
    }

    public static void main(String[] args) {
        init();
        ListVoicesRequest allVoicesRequest = new ListVoicesRequest();
        ListVoicesResult allVoicesResult = speechCloud.listVoices(allVoicesRequest);
        System.out.println("All voices: " + allVoicesResult);

        ListVoicesRequest enUsVoicesRequest = new ListVoicesRequest();
        Voice voice = new Voice();
        voice.setLanguage("en-US");
        enUsVoicesRequest.setVoice(voice);
        ListVoicesResult enUsVoiceResult = speechCloud.listVoices(enUsVoicesRequest);
        System.out.println("en-US voices: " + enUsVoiceResult);
    }

}
