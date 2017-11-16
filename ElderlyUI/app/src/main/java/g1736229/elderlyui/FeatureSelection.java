package g1736229.elderlyui;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapLabel;

import static android.R.attr.src;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H2;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H6;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading;

public class FeatureSelection extends AppCompatActivity {
    String textSize = "14";
    String headingStyle = null;
    public static final String HEADING_STYLE = "g17361229.elderlyui.HEADING_STYLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_selection);

        Intent intent = getIntent();
        textSize = intent.getStringExtra(ImpairmentDetectionActivity.EXTRA_TEXT_SIZE);
        headingStyle = intent.getStringExtra(ImpairmentDetectionActivity.HEADING_STYLE);
        Headings headingsObj = new Headings();

        int widthSize = Integer.parseInt(textSize) * 8;
        int heightSize = Integer.parseInt(textSize) * 6;

        final float scale = getResources().getDisplayMetrics().density;
        int heightDp = (int) (heightSize * scale + 0.5f);
        int widthDp = (int) (widthSize * scale + 0.5f);

        BootstrapLabel b = (BootstrapLabel)findViewById(R.id.button4);
        b.setBootstrapHeading(headingsObj.getCorrespondingHeadingClass(headingStyle));
        ViewGroup.LayoutParams params = b.getLayoutParams();//b========>ur button
        params.height = heightDp;
        params.width = widthDp;
        b.setLayoutParams(params);
        b.requestLayout();

        BootstrapLabel c = (BootstrapLabel)findViewById(R.id.button5);
        c.setBootstrapHeading(headingsObj.getCorrespondingHeadingClass(headingStyle));
        ViewGroup.LayoutParams params2 = c.getLayoutParams();//b========>ur button
        params2.height = heightDp;
        params2.width = widthDp;
        c.setLayoutParams(params2);
        c.requestLayout();
    }

    public void openGalleryActivity(View v) {
        Intent cameraIntent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivity(cameraIntent);

    }

    public void openContactsActivity(View v) {
        Intent intent = new Intent(this, ContactsActivity.class);
        intent.putExtra(ImpairmentDetectionActivity.EXTRA_TEXT_SIZE, textSize);
        intent.putExtra(ImpairmentDetectionActivity.HEADING_STYLE, headingStyle);
        startActivity(intent);
    }

}
