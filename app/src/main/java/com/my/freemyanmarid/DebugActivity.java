package com.my.freemyanmarid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/* loaded from: classes57.dex */
public class DebugActivity extends Activity {
    private String[] exceptionTypes = {"StringIndexOutOfBoundsException", "IndexOutOfBoundsException", "ArithmeticException", "NumberFormatException", "ActivityNotFoundException"};
    private String[] exceptionMessages = {"Invalid string operation\n", "Invalid list operation\n", "Invalid arithmetical operation\n", "Invalid toNumber block operation\n", "Invalid intent operation"};

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3 A[PHI: r1
      0x00d3: PHI (r1v2 java.lang.String) = (r1v1 java.lang.String), (r1v12 java.lang.String) binds: [B:3:0x000c, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle bundle) {
        String stringExtra;
        int i = 0;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = "";
        if (intent != null) {
            stringExtra = intent.getStringExtra("error");
            String[] strArrSplit = stringExtra.split("\n");
            while (true) {
                try {
                    if (i >= this.exceptionTypes.length) {
                        break;
                    }
                    if (!strArrSplit[0].contains(this.exceptionTypes[i])) {
                        i++;
                    } else {
                        str = String.valueOf(String.valueOf(this.exceptionMessages[i]) + strArrSplit[0].substring(this.exceptionTypes[i].length() + strArrSplit[0].indexOf(this.exceptionTypes[i]), strArrSplit[0].length())) + "\n\nDetailed error message:\n" + stringExtra;
                        break;
                    }
                } catch (Exception e) {
                    stringExtra = String.valueOf(str) + "\n\nError while getting error: " + Log.getStackTraceString(e);
                }
            }
            if (!str.isEmpty()) {
                stringExtra = str;
            }
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle("An error occurred").setMessage(stringExtra).setPositiveButton("End Application", new DialogInterface.OnClickListener() { // from class: com.my.freemyanmarid.DebugActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                DebugActivity.this.finish();
            }
        }).create();
        alertDialogCreate.show();
        ((TextView) alertDialogCreate.findViewById(android.R.id.message)).setTextIsSelectable(true);
    }
}
