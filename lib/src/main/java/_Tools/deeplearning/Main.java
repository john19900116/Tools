package _Tools.deeplearning;

import java.io.IOException;

import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation ;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.ConvolutionLayer;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.layers.SubsamplingLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;
public class Main {

	public static void main(String[] args) throws IOException {
		   int nChannels = 1;
	        int outputNum = 10;
	        int batchSize = 64;
	        int nEpochs = 10;

	        MnistDataSetIterator trainData = new MnistDataSetIterator(batchSize, true, 12345);
	        MnistDataSetIterator testData = new MnistDataSetIterator(batchSize, false, 12345);

	        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
	                .seed(12345)
	                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
	                .updater(new Adam())
	                .list()
	                .layer(0, new ConvolutionLayer.Builder(5, 5)
	                        .nIn(nChannels)
	                        .stride(1, 1)
	                        .nOut(20)
	                        .activation(Activation.RELU)
	                        .build())
	                .layer(1, new SubsamplingLayer.Builder(SubsamplingLayer.PoolingType.MAX)
	                        .kernelSize(2, 2)
	                        .stride(2, 2)
	                        .build())
	                .layer(2, new ConvolutionLayer.Builder(5, 5)
	                        .stride(1, 1)
	                        .nOut(50)
	                        .activation(Activation.RELU)
	                        .build())
	                .layer(3, new SubsamplingLayer.Builder(SubsamplingLayer.PoolingType.MAX)
	                        .kernelSize(2, 2)
	                        .stride(2, 2)
	                        .build())
	                .layer(4, new DenseLayer.Builder().activation(Activation.RELU)
	                        .nOut(500)
	                        .build())
	                .layer(5, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
	                        .nOut(outputNum)
	                        .activation(Activation.SOFTMAX)
	                        .build())
	                .build();

	        MultiLayerNetwork model = new MultiLayerNetwork(conf);
	        model.init();
	        model.setListeners(new ScoreIterationListener(10));

	        for (int i = 0; i < nEpochs; i++) {
	            while (trainData.hasNext()) {
	                DataSet dataSet = trainData.next();
	                model.fit(dataSet);
	            }
	            trainData.reset();
	        }

	        Evaluation eval = new Evaluation(outputNum);
	        while (testData.hasNext()) {
	            DataSet dataSet = testData.next();
	            INDArray output = model.output(dataSet.getFeatures(), false);
	            eval.eval(dataSet.getLabels(), output);
	        }

	        System.out.println(eval.stats());
	    
	}

}
