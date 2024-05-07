# Use Node.js version 15.14.0 as the base image
FROM node:15.14.0 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code to the working directory
COPY . .

# Build the Angular application for production
RUN npm run build

# Use NGINX as the base image for serving the Angular application
FROM nginx:alpine

# Copy the built Angular app from the previous stage into the NGINX image
COPY --from=builder /app/dist/* /usr/share/nginx/html/

# Expose port 80 to allow external access to the NGINX server
EXPOSE 80

# Command to run NGINX in the foreground when the container starts
CMD ["nginx", "-g", "daemon off;"]
