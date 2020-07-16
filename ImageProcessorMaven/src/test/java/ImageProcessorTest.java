import de.telran.ImageProcessor;
import de.telran.entity.ActionableImage;
import de.telran.entity.DownloadedImage;
import de.telran.entity.ImageDescriptor;
import de.telran.service.DownloadService;
import de.telran.service.FileService;
import de.telran.service.ImageDescriptorService;
import de.telran.service.ImageService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ImageProcessorTest {

    ImageDescriptorService imageDescriptorService = mock(ImageDescriptorService.class);
    ActionableImage actionableImage = mock(ActionableImage.class);
    DownloadService downloadService = mock(DownloadService.class);
    ImageService imageService = mock(ImageService.class);
    FileService fileService = mock(FileService.class);

    ImageProcessor processor;


    @Before
    public void setUp() {
        processor = new ImageProcessor(imageDescriptorService, downloadService, imageService, fileService);
    }

    @Test
    public void testDoProcessing() {
        //configure mock
        List<ImageDescriptor> testImageDescriptor = createTestImageDescriptors();
        List<ActionableImage> testActionableImage = createActionableImage();
//        ActionableImage actionableImage = createOneActionableImage();
//        List<String> testStringsFromFile = createStringsFromFile();
        when(imageDescriptorService.getImageDescriptors(any())).thenReturn(testImageDescriptor);
        when(downloadService.downloadImages(any())).thenReturn(testActionableImage);
//        when(imageService.processImage(any())).thenReturn(actionableImage);
//        when(fileService.loadStringsFromFile(any())).thenReturn(testStringsFromFile);
        //execute test method
        processor.doProcessing("test.txt");
        //verify
        verify(imageDescriptorService, times(1)).getImageDescriptors("test.txt");
        verify(downloadService, times(1)).downloadImages(any());
//        verify(imageService, times(2)).processImage(any());
//        verify(fileService, times(2)).loadStringsFromFile(any());

//        Wanted but not invoked:
//        fileService.loadStringsFromFile(<any>);
//-> at ImageProcessorTest.testDoProcessing(ImageProcessorTest.java:51)
//
//        However, there were exactly 2 interactions with this mock:
//        fileService.saveImageAsFile(
//                ActionableImage{image=null, isSuccessfull=false, sourceUrl='http://server.com/image1.jpg', actionName='PREVIEW'}
//);
//-> at de.telran.ImageProcessor.lambda$doProcessing$2(ImageProcessor.java:48)
//
//        fileService.saveImageAsFile(
//                ActionableImage{image=null, isSuccessfull=false, sourceUrl='http://server.com/image1.jpg', actionName='PREVIEW'}
//);
//-> at de.telran.ImageProcessor.lambda$doProcessing$2(ImageProcessor.java:48)

    }

    private List<String> createStringsFromFile() {
        return  Arrays.asList(
                "http://server.com/image1.jpg;PREVIEW",
                "http://server.com/image2.jpg;THUMBNAIL"
        );
    }


    public static  ActionableImage createOneActionableImage(){
        return  new ActionableImage(null, false, "http://server.com/image1.jpg", "PREVIEW");
    }

    private static List<ActionableImage> createActionableImage(){
        return  Arrays.asList(
                new ActionableImage(null, true, "http://server.com/image1.jpg", "PREVIEW"),
                new ActionableImage(null, true, "http://server.com/image2.jpg", "THUMBNAIL"));
}


    private static List<DownloadedImage> createDownloadedImage() {
        return Arrays.asList(
                new DownloadedImage(null, true, new ImageDescriptor("http://server.com/image1.jpg", "PREVIEW")),
                new DownloadedImage(null, true, new ImageDescriptor("http://server.com/image2.jpg", "THUMBNAIL"))
        );
    }

    private static List<ImageDescriptor> createTestImageDescriptors() {
        return Arrays.asList(
                new ImageDescriptor("http://server.com/image1.jpg", "PREVIEW"),
                new ImageDescriptor("http://server.com/image2.jpg", "THUMBNAIL"));
    }
}
