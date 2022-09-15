package fr.milweb_tls.meteotestpsa.interfaces

import androidx.fragment.app.FragmentManager

interface OnResponseTransfert {

    fun sendResponse(fragmentManager: FragmentManager?, codePostal: String?, fromList: Int)
}