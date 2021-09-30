// Generated by view binder compiler. Do not edit!
package com.example.tp3_mmm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.example.tp3_mmm.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ClientItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView birthday;

  @NonNull
  public final TextView nom;

  @NonNull
  public final TextView prenom;

  @NonNull
  public final TextView villeNaissance;

  private ClientItemBinding(@NonNull CardView rootView, @NonNull TextView birthday,
      @NonNull TextView nom, @NonNull TextView prenom, @NonNull TextView villeNaissance) {
    this.rootView = rootView;
    this.birthday = birthday;
    this.nom = nom;
    this.prenom = prenom;
    this.villeNaissance = villeNaissance;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ClientItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ClientItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.client_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ClientItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.birthday;
      TextView birthday = rootView.findViewById(id);
      if (birthday == null) {
        break missingId;
      }

      id = R.id.nom;
      TextView nom = rootView.findViewById(id);
      if (nom == null) {
        break missingId;
      }

      id = R.id.prenom;
      TextView prenom = rootView.findViewById(id);
      if (prenom == null) {
        break missingId;
      }

      id = R.id.villeNaissance;
      TextView villeNaissance = rootView.findViewById(id);
      if (villeNaissance == null) {
        break missingId;
      }

      return new ClientItemBinding((CardView) rootView, birthday, nom, prenom, villeNaissance);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}