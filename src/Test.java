//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//
//public class Test {
//
//    public  boolean installAssetPlugin() {
//        Plug_Manifest meta = null;
//        if(PluginManager.getDefaultPlugin().get(mPluginId) == null)return false;
//        synchronized (this) {
//            isAssetInstalling = true;
//            if (isInstall(PluginManager.getDefaultPlugin().get(mPluginId), false)) {
//                isInstalling = false;
//                return true;
//            }
//            PluginUtil.createDir(PluginUtil.getPlugDir(mPluginId));
//            mPathInfo = String.valueOf(System.currentTimeMillis());
//
//            FileOutputStream out = null;
//            InputStream in = null;
//            StringBuilder errorString=new StringBuilder();
//            try {
//                errorString.append(" getAssets ");
//                AssetManager am = IreaderApplication.getInstance().getAssets();
//                errorString.append(" am.open ");
//                in = am.open(mPluginId + PluginPath.PLUGINWEB_APK_SUFF);
//                errorString.append(" createDirWithFile ");
//                FILE.createDirWithFile(getAPKPath(mPluginId));
//                errorString.append(" new FileOutputStream ");
//                out = new FileOutputStream(getAPKPath(mPluginId), false);
//                errorString.append(" in.read ");
//                byte[] temp = new byte[2048];
//                int len = 0;
//                errorString.append(" read ");
//                while ((len = in.read(temp)) > 0) {
//                    out.write(temp, 0, len);
//                }
//            } catch (Exception e) {
//                LOG.E("log",e.getMessage());
//                mPathInfo = getPathInfoNoCache();
//                isInstalling = false;
//                return false;
//            } finally {
//                Util.close(in);
//                Util.close(out);
//            }
//            //拷贝so文件
//            if (!PluginUtil.EXP_BOOKDETAIL.equals(mPluginId) &&
//                    !PluginUtil.EXP_MOVIE.equals(mPluginId) &&
//                    !PluginUtil.EXP_SEARCH.equals(mPluginId) &&
//                    !PluginUtil.EXP_ZXING.equals(mPluginId) &&
//                    !PluginUtil.EXP_CONFIG.equals(mPluginId)) {//这几个插件没有so文件，没必要去检查
//                if (!copySoFile(mPathInfo, PluginUtil.getCpuArchitecture())) {
//                    isInstalling = false;
//                    mPathInfo = getPathInfoNoCache();
//                    return false;
//                }
//            }
//            meta = super.getPluginMeta();
//            if (meta == null) {
//                FILE.deleteFileSafe(new File(getAPKPath(mPluginId)));
//                isAssetInstalling = false;
//                mPathInfo = getPathInfoNoCache();
//                return false;
//            }
//            if (!writePathInfo(mPathInfo)) {
//                isAssetInstalling = false;
//                mPathInfo = getPathInfoNoCache();
//                return false;
//            }
//            isAssetInstalling = false;
//        }
//        PluginManager.addInstalledPlugin(mPluginId, meta);
//        setMeta(meta);
//        return true;
//    }
//}
