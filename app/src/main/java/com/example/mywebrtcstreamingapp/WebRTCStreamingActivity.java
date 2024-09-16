//package com.example.mywebrtcstreamingapp;
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import io.antmedia.webrtcandroidframework.api.IWebRTCClient;
//import org.webrtc.SurfaceViewRenderer;
//
//public class WebRTCStreamingActivity extends Activity {
//
//    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
//    private IWebRTCClient webRTCClient;
//    private SurfaceViewRenderer surfaceViewRenderer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.webrtc_streaming);
//
//        // Request necessary permissions (CAMERA, RECORD_AUDIO)
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{
//                    Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, CAMERA_PERMISSION_REQUEST_CODE);
//        } else {
//            // Initialize WebRTC client after permissions are granted
//            initWebRTCClient();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                // Permissions granted, initialize WebRTC
//                initWebRTCClient();
//            } else {
//                // Permission denied
//                Toast.makeText(this, "Camera and audio permissions are required to start streaming", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void initWebRTCClient() {
//        surfaceViewRenderer = findViewById(R.id.full_screen_renderer);
//
//        // Initialize WebRTC client for streaming
//        webRTCClient = IWebRTCClient.builder()
//                .setActivity(this)
//                .setLocalVideoRenderer(surfaceViewRenderer)
//                .setServerUrl("wss://test.antmedia.io:5443/WebRTCAppEE/websocket")
//                .build();
//
//        // Start streaming
//        try {
//            webRTCClient.publish("stream1");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Failed to start streaming: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//}
//
//package com.example.mywebrtcstreamingapp;
//
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import com.robotemi.sdk.Robot;
//import io.antmedia.webrtcandroidframework.api.IWebRTCClient;
//import org.webrtc.SurfaceViewRenderer;
//
//public class WebRTCStreamingActivity extends Activity {
//
//    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
//    private IWebRTCClient webRTCClient;
//    private SurfaceViewRenderer surfaceViewRenderer;
//    private Robot robot;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.webrtc_streaming);
//
//        // Initialize Temi SDK
//        robot = Robot.getInstance();
//
//        // Request necessary permissions (CAMERA, RECORD_AUDIO)
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{
//                    Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, CAMERA_PERMISSION_REQUEST_CODE);
//        } else {
//            // Initialize WebRTC client after permissions are granted
//            initWebRTCClient();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                // Permissions granted, initialize WebRTC
//                initWebRTCClient();
//            } else {
//                // Permission denied
//                Toast.makeText(this, "Camera and audio permissions are required to start streaming", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void initWebRTCClient() {
//        surfaceViewRenderer = findViewById(R.id.full_screen_renderer);
//
//        // Initialize WebRTC client for streaming
//        webRTCClient = IWebRTCClient.builder()
//                .setActivity(this)
//                .setLocalVideoRenderer(surfaceViewRenderer)
//                .setServerUrl("wss://test.antmedia.io:5443/WebRTCAppEE/websocket")
//                .build();
//
//        // Start streaming
//        try {
//            webRTCClient.publish("stream1");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Failed to start streaming: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (robot != null) {
//            robot.removeOnGoToLocationStatusChangedListener((location, status, description, event) -> {
//                // Handle the location status change with the correct number of parameters
//            });
//        }
//
//    }
//
//}

package com.example.mywebrtcstreamingapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.robotemi.sdk.Robot;
import io.antmedia.webrtcandroidframework.api.IWebRTCClient;
import org.webrtc.SurfaceViewRenderer;

public class WebRTCStreamingActivity extends Activity {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private IWebRTCClient webRTCClient;
    private SurfaceViewRenderer surfaceViewRenderer;
    private Robot robot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webrtc_streaming);

        // Initialize Temi SDK
        robot = Robot.getInstance();

        // Request necessary permissions (CAMERA, RECORD_AUDIO)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            // Initialize WebRTC client after permissions are granted
            initWebRTCClient();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // Permissions granted, initialize WebRTC
                initWebRTCClient();
            } else {
                // Permission denied
                Toast.makeText(this, "Camera and audio permissions are required to start streaming", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initWebRTCClient() {
        surfaceViewRenderer = findViewById(R.id.full_screen_renderer);

        // Initialize WebRTC client for streaming
        webRTCClient = IWebRTCClient.builder()
                .setActivity(this)
                .setLocalVideoRenderer(surfaceViewRenderer)
                .setServerUrl("wss://test.antmedia.io:5443/WebRTCAppEE/websocket")
                .build();

        // Start streaming
        try {
            webRTCClient.publish("stream1");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to start streaming: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}

//package com.example.mywebrtcstreamingapp;
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import io.antmedia.webrtcandroidframework.api.IWebRTCClient;
//import org.webrtc.SurfaceViewRenderer;
//
//public class WebRTCStreamingActivity extends Activity {
//
//    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
//    private IWebRTCClient webRTCClient;
//    private SurfaceViewRenderer surfaceViewRenderer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.webrtc_streaming);
//
//        // Request necessary permissions (CAMERA, RECORD_AUDIO)
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{
//                    Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, CAMERA_PERMISSION_REQUEST_CODE);
//        } else {
//            // Initialize WebRTC client after permissions are granted
//            initWebRTCClient();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                // Permissions granted, initialize WebRTC
//                initWebRTCClient();
//            } else {
//                // Permission denied
//                Toast.makeText(this, "Camera and audio permissions are required to start streaming", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void initWebRTCClient() {
//        surfaceViewRenderer = findViewById(R.id.full_screen_renderer);
//
//        // Initialize WebRTC client for streaming
//        webRTCClient = IWebRTCClient.builder()
//                .setActivity(this)
//                .setLocalVideoRenderer(surfaceViewRenderer)
//                .setServerUrl("wss://test.antmedia.io:5443/WebRTCAppEE/websocket")
//                .build();
//
//        // Start streaming
//        try {
//            webRTCClient.publish("stream1");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Failed to start streaming: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (webRTCClient != null) {
//            webRTCClient.disconnect();  // Use disconnect or stop method based on your SDK version
//        }
//    }
//}

